package com.mediaid.mediaid.service.implement;

import com.mediaid.mediaid.DTO.chanDoan.*;
import com.mediaid.mediaid.model.*;
import com.mediaid.mediaid.repository.*;
import com.mediaid.mediaid.service.abstracts.ChanDoanService;
import com.mediaid.mediaid.util.CommonUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class ChanDoanServiceImpl implements ChanDoanService {
    @Autowired
    PhanVungCoTheRepo phanVungCoTheRepo;
    @Autowired
    BoPhanCoTheRepo boPhanCoTheRepo;
    @Autowired
    TrieuChungRepo trieuChungRepo;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    PhongKhamChiTietRepo phongKhamChiTietRepo;
    @Autowired
    ChanDoanBangBoPhanVaTrieuChungRepo chanDoanBangBoPhanVaTrieuChungRepo;
    @Autowired
    SoKhamTheoPhongRepo soKhamTheoPhongRepo;
    @Autowired
    CoSoBenhVienRepo coSoBenhVienRepo;
    @Autowired
    TrangThaiKhamSoBoRepo trangThaiKhamSoBoRepo;
    @Autowired
    LichSuKhamRepo lichSuKhamRepo;
    @Autowired
    LichSuKhamChiTietRepo lichSuKhamChiTietRepo;
    @Autowired
    BacSiRepo bacSiRepo;

    @Override
    public ResponseEntity<?> layDanhSachBoPhanVaTrieuChung(String accountID) {
        List<PhanVungCoThe> phanVungCoTheList = phanVungCoTheRepo.findByStatus(true);
        List<DanhSachBoPhanVaTrieuChung> danhSachBoPhanHashMap = new ArrayList<>();
        TaiKhoan taiKhoan = accountRepo.findByAccountID(accountID);
        if (CommonUtil.isNullOrEmpty(taiKhoan)){
            return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message","Invalid accountID"));
        }
        int gioiTinhID = taiKhoan.getGioiTinh().getGioiTinhID();

        DanhSachBoPhanVaTrieuChung danhSachBoPhanVaTrieuChung;
        List<BoPhanCoThe> boPhanCoThes;
        List<TrieuChung> trieuChungs;
        DanhSachBoPhan danhSachBoPhan;
        List<DanhSachBoPhan> danhSachBoPhans;
        DanhSachTrieuChung danhSachTrieuChung;
        List<DanhSachTrieuChung> danhSachTrieuChungs;

        for(PhanVungCoThe phanVungCoThe: phanVungCoTheList){
            danhSachBoPhanVaTrieuChung = new DanhSachBoPhanVaTrieuChung(phanVungCoThe.getPhanVungID(),phanVungCoThe.getTen());
            boPhanCoThes = boPhanCoTheRepo.findByStatusAndGioiTinhIDAndPhanVungID(true, gioiTinhID, phanVungCoThe.getPhanVungID());

            if (!CommonUtil.isNullOrEmpty(boPhanCoThes)){
                danhSachBoPhans = new ArrayList<>();
                for (BoPhanCoThe boPhanCoThe: boPhanCoThes){
                    danhSachBoPhan = new DanhSachBoPhan(boPhanCoThe.getBoPhanID(), boPhanCoThe.getTen());
                    trieuChungs = trieuChungRepo.findByStatusAndBoPhanID(true, boPhanCoThe.getBoPhanID());
                    if(!CommonUtil.isNullOrEmpty(trieuChungs)){
                        danhSachTrieuChungs = new ArrayList<>();
                        for(TrieuChung trieuChung: trieuChungs){
                            danhSachTrieuChung = new DanhSachTrieuChung(trieuChung.getTrieuChungID(), trieuChung.getTrieuChung());
                            danhSachTrieuChungs.add(danhSachTrieuChung);
                        }
                        danhSachBoPhan.setDanhSachTrieuChungs(danhSachTrieuChungs);
                    }
                    danhSachBoPhans.add(danhSachBoPhan);
                }
                danhSachBoPhanVaTrieuChung.setDanhSachBoPhanList(danhSachBoPhans);
            }
            danhSachBoPhanHashMap.add(danhSachBoPhanVaTrieuChung);
        }
        return ResponseEntity.ok(danhSachBoPhanHashMap);
    }

    @Override
    @Transactional
    public ResponseEntity<?> chanDoan(ChanDoanDTO chanDoanDTO) {
        KetQuaChanDoanDTO ketQuaChanDoanDTO = new KetQuaChanDoanDTO("", "");
        TaiKhoan taiKhoan = accountRepo.findByAccountID(chanDoanDTO.getAccountID());
        log.info(chanDoanDTO.getAccountID());
        if(taiKhoan == null){
            ketQuaChanDoanDTO.setMessage("AccountID không hợp lệ");
            return ResponseEntity.badRequest().body(ketQuaChanDoanDTO);
        }
        if(lichSuKhamChiTietRepo.checkNumberOfLichSuKhamDangChoOnCurrentDay(taiKhoan.getSoKham().getSoKhamID(), LocalDate.now(), 1)>=2){
            ketQuaChanDoanDTO.setMessage("Bạn đã có 2 lịch đang khám trong ngày hôm nay, hãy hủy 1 trong các lịch khám để đặt lịch khám mới");
            return ResponseEntity.badRequest().body(ketQuaChanDoanDTO);
        }
        Optional<CoSoBenhVien> coSoBenhVien = coSoBenhVienRepo.findById(chanDoanDTO.getCoSoID());
        if(coSoBenhVien.isEmpty()){
            ketQuaChanDoanDTO.setMessage("Xin hãy chọn cơ sở khám bệnh trước khi lấy lịch khám");
            return ResponseEntity.badRequest().body(ketQuaChanDoanDTO);
        }
        List<PhongKhamChiTiet> phongKhamChiTiets = new ArrayList<>();
        log.info("cosobenhVien: "+chanDoanDTO.getCoSoID());
        log.info("phanVungID: "+chanDoanDTO.getPhanVungID());
        log.info("boPhanID: "+chanDoanDTO.getBoPhanID());
        log.info("trieuChungID: "+(chanDoanDTO.getTrieuChungID()!=null ? chanDoanDTO.getTrieuChungID().size() : null));
        if(!CommonUtil.isNullOrEmpty(chanDoanDTO.getPhanVungID())){
            phongKhamChiTiets = phongKhamChiTietRepo.findbyPhanVungID(chanDoanDTO.getPhanVungID(), chanDoanDTO.getCoSoID());
        } else if(!CommonUtil.isNullOrEmpty(chanDoanDTO.getBoPhanID()) && CommonUtil.isNullOrEmpty(chanDoanDTO.getTrieuChungID())){
            phongKhamChiTiets = phongKhamChiTietRepo.findbyBoPhanID(chanDoanDTO.getBoPhanID(), chanDoanDTO.getCoSoID());
        } else if(!CommonUtil.isNullOrEmpty(chanDoanDTO.getTrieuChungID()) && !CommonUtil.isNullOrEmpty(chanDoanDTO.getTrieuChungID())){
            List<ChanDoanBangBoPhanVaTrieuChung> chanDoanBangBoPhanVaTrieuChungs = chanDoanBangBoPhanVaTrieuChungRepo.findByBoPhanIDAndTrieuChungIDList(chanDoanDTO.getBoPhanID(), chanDoanDTO.getTrieuChungID());
            Map<String, Integer> stringIntegerMap = new HashMap<>();
            String key;
            int maxEsi = 0;
            for (ChanDoanBangBoPhanVaTrieuChung chanDoanBangBoPhanVaTrieuChung: chanDoanBangBoPhanVaTrieuChungs){
                key = chanDoanBangBoPhanVaTrieuChung.getPhongKham().getPhongKhamID();
                Integer esi = stringIntegerMap.get(key);
                if(CommonUtil.isNullOrEmpty(esi)){
                    stringIntegerMap.put(key, chanDoanBangBoPhanVaTrieuChung.getESI());
                    maxEsi = chanDoanBangBoPhanVaTrieuChung.getESI();
                } else {
                    int esiPlus = esi + chanDoanBangBoPhanVaTrieuChung.getESI();
                    stringIntegerMap.replace(key,esiPlus);
                    if(esiPlus > maxEsi) {
                        maxEsi = esiPlus;
                    }
                }
            }
            List<String> strings = new ArrayList<>();
            for (Map.Entry<String, Integer> stringIntegerEntry: stringIntegerMap.entrySet()){
                if (stringIntegerEntry.getValue() == maxEsi){
                    strings.add(stringIntegerEntry.getKey());
                }
            }
            if(strings.size()>1){
                phongKhamChiTiets = phongKhamChiTietRepo.findbyBoPhanID(chanDoanDTO.getBoPhanID(), chanDoanDTO.getCoSoID());
            } else {
                List<PhongKhamChiTiet> phongKhamChiTietListSoBo = phongKhamChiTietRepo.findPhongKhamHoTrobyBoPhanID(chanDoanDTO.getBoPhanID(), true, chanDoanDTO.getCoSoID());
                List<PhongKhamChiTiet> phongKhamChiTietListChanDoan = phongKhamChiTietRepo.findByphonngKhamID(strings.get(0), chanDoanDTO.getCoSoID());

                phongKhamChiTiets.addAll(phongKhamChiTietListSoBo);
                phongKhamChiTiets.addAll(phongKhamChiTietListChanDoan);
            }
        } else {
            ketQuaChanDoanDTO.setMessage("Combo chẩn đoán để chọn phòng không hợp lệ");
            return ResponseEntity.badRequest().body(ketQuaChanDoanDTO);
        }
        if(CommonUtil.isNullOrEmpty(phongKhamChiTiets)){
            ketQuaChanDoanDTO.setMessage("Không có phòng khám nào hợp lệ với lựa chọn của bạn");
            return ResponseEntity.badRequest().body(ketQuaChanDoanDTO);
        }
        int smallestNumber=0;
        PhongKhamChiTiet available = null;
        for (PhongKhamChiTiet phongKhamChiTiet: phongKhamChiTiets){
            Integer soKhamHienTai = soKhamTheoPhongRepo.findLastestNumberOfPhongKhamChiTiet(phongKhamChiTiet.getPhongKhamChiTietID(), LocalDate.now());
            if(CommonUtil.isNullOrEmpty(soKhamHienTai)){
                smallestNumber = 0;
                available = phongKhamChiTiet;
                break;
            }
            if(smallestNumber==0){
                smallestNumber = soKhamHienTai;
                available = phongKhamChiTiet;
                continue;
            }
            if(soKhamHienTai >= phongKhamChiTiet.getGioiHanLaySo()){
                continue;
            }
            if(soKhamHienTai<smallestNumber){
                smallestNumber = soKhamHienTai;
                available = phongKhamChiTiet;
            }
        }
        if(available == null){
            ketQuaChanDoanDTO.setMessage("Hiện tại không có phòng khám nào còn slot");
            return ResponseEntity.badRequest().body(ketQuaChanDoanDTO);
        }

        if(!CommonUtil.isNullOrEmpty(lichSuKhamChiTietRepo.checkIfUserHaveNumberAtThisRoom(taiKhoan.getSoKham().getSoKhamID(), available.getPhongKham().getPhongKhamID(), LocalDate.now()))){
            ketQuaChanDoanDTO.setMessage("Bạn đã có số trong phòng khám này");
            return ResponseEntity.badRequest().body(ketQuaChanDoanDTO);
        }

        SoKhamTheoPhong soKhamTheoPhong = new SoKhamTheoPhong(UUID.randomUUID().toString(),smallestNumber+1, LocalDate.now(),"Chua Kham", available);
        soKhamTheoPhongRepo.save(soKhamTheoPhong);

        Optional<TrangThaiKham> trangThaiKham = trangThaiKhamSoBoRepo.findById(1);
        if(trangThaiKham.isEmpty()){
            ketQuaChanDoanDTO.setMessage("Không tìm thấy TrangThaiKham");
            return ResponseEntity.badRequest().body(ketQuaChanDoanDTO);
        }

        LichSuKham lichSuKham = new LichSuKham();
        lichSuKham.setLichSuKhamID(UUID.randomUUID().toString());
        lichSuKham.setSoKham(taiKhoan.getSoKham());
        lichSuKham.setNgayKham(LocalDateTime.now());
        lichSuKham.setCoSoBenhVien(coSoBenhVien.get());
        lichSuKham.setTrangThaiKham(trangThaiKham.get());
        lichSuKham.setBacSi(bacSiRepo.findAll().get(0));
        try{
            lichSuKham = lichSuKhamRepo.save(lichSuKham);
        }catch (Exception e){
            log.error("Exception", e);
            ketQuaChanDoanDTO.setMessage("Lưu lichSuKham thất bại");
            return ResponseEntity.badRequest().body(ketQuaChanDoanDTO);
        }

        DichVuKham dichVuKhamTestData = available.getPhongKham().getDichVuKham();
        LichSuKhamChiTiet lichSuKhamChiTiet = new LichSuKhamChiTiet();
        lichSuKhamChiTiet.setNgayKham(LocalDateTime.now());
        lichSuKhamChiTiet.setLichSuKham(lichSuKham);
        lichSuKhamChiTiet.setSoKhamThuTu(smallestNumber+1);
        lichSuKhamChiTiet.setGia(dichVuKhamTestData.getGia());
        lichSuKhamChiTiet.setTenDichVuKham(dichVuKhamTestData.getTenLoai());
        lichSuKhamChiTiet.setPhongKhamChiTiet(available);
        lichSuKhamChiTiet.setLichSuKhamChiTietID(UUID.randomUUID().toString());
        lichSuKhamChiTietRepo.save(lichSuKhamChiTiet);
        try{
            lichSuKhamChiTiet = lichSuKhamChiTietRepo.save(lichSuKhamChiTiet);
            lichSuKham.setTongThu(lichSuKhamChiTiet.getGia());
            lichSuKhamRepo.save(lichSuKham);
            log.info("Ket qua xep so: "+lichSuKhamChiTiet.getLichSuKhamChiTietID());
            ketQuaChanDoanDTO.setLichSuKhamID(lichSuKham.getLichSuKhamID());
            return ResponseEntity.badRequest().body(ketQuaChanDoanDTO);
        }catch (Exception e){
            log.error("Exception", e);
            ketQuaChanDoanDTO.setMessage("Lưu lichSuKham thất bại");
            return ResponseEntity.badRequest().body(ketQuaChanDoanDTO);
        }
    }
}
