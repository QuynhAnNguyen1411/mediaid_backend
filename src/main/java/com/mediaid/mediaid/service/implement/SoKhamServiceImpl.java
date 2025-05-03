package com.mediaid.mediaid.service.implement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediaid.mediaid.DTO.form.formTieuSuYTe.*;
import com.mediaid.mediaid.DTO.staticData.GetMappingData.SoKhamDTO;
import com.mediaid.mediaid.model.*;
import com.mediaid.mediaid.repository.*;
import com.mediaid.mediaid.service.abstracts.SoKhamService;
import com.mediaid.mediaid.util.CommonUtil;
import com.mediaid.mediaid.util.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class SoKhamServiceImpl implements SoKhamService {
    @Autowired
    MucDoRepo mucDoRepo;
    @Autowired
    PhuongPhapDieuTriRepo phuongPhapDieuTriRepo;
    @Autowired
    SoKhamRepo soKhamRepo;
    @Autowired
    TieuSuBenhTatRepo tieuSuBenhTatRepo;
    @Autowired
    TieuSuBenhDiTruyenRepo tieuSuBenhDiTruyenRepo;
    @Autowired
    TieuSuDiUngRepo tieuSuDiUngRepo;
    @Autowired
    TieuSuPhauThuatRepo tieuSuPhauThuatRepo;
    @Autowired
    LyDoPhauThuatRepo lyDoPhauThuatRepo;
    @Autowired
    TinhTrangSuDungRepo tinhTrangSuDungRepo;
    @Autowired
    TieuSuThuocRepo tieuSuThuocRepo;
    @Autowired
    LoaiSanPhamRepo loaiSanPhamRepo;
    @Autowired
    LoiSongNguoiBenhRepo loiSongNguoiBenhRepo;
    @Autowired
    MoiTruongRepo moiTruongRepo;
    @Autowired
    ThoiQuenLoiSongRepo thoiQuenLoiSongRepo;
    @Autowired
    ThoiQuenRepo thoiQuenRepo;

    @Override
    public ResponseEntity<?> capNhatTieuSuBenhTat(TieuSuBenhTatDTO tieuSuBenhTatDTO, BindingResult bindingResult) {
        HashMap<String, String> errors = ValidationUtil.validationCheckBindingResult(bindingResult);
        if (!CommonUtil.isNullOrEmpty(errors)) {
            log.warn(errors.toString());
            return ResponseEntity.badRequest().body(errors);
        }
        MucDo mucDo;
        PhuongPhapDieuTri phuongPhapDieuTri;
        SoKham soKham;
        TieuSuBenhTat tieuSuBenhTat;
        try {
            soKham = soKhamRepo.findSoKhamByAccountID(tieuSuBenhTatDTO.getAccountID());
            mucDo = mucDoRepo.findByMucDoID(tieuSuBenhTatDTO.getMucDoID());
            phuongPhapDieuTri = phuongPhapDieuTriRepo.findByPhuongPhapDieuTriID(tieuSuBenhTatDTO.getPhuongPhapDieuTriID());
            if (CommonUtil.isNullOrEmpty(soKham) || CommonUtil.isNullOrEmpty(mucDo) || CommonUtil.isNullOrEmpty(phuongPhapDieuTri)) {
                log.warn("Invalid id data in request " + new ObjectMapper().writeValueAsString(tieuSuBenhTatDTO));
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid data"));
            }
            if (CommonUtil.isNullOrEmpty(tieuSuBenhTatDTO.getTieuSuBenhTatID())) {
                tieuSuBenhTat = new TieuSuBenhTat();
                tieuSuBenhTat.setSoKham(soKham);
                tieuSuBenhTat.setTieuSuBenhTatID(UUID.randomUUID().toString());
            } else {
                tieuSuBenhTat = tieuSuBenhTatRepo.findByTieuSuBenhTatID(tieuSuBenhTatDTO.getTieuSuBenhTatID());
                if (CommonUtil.isNullOrEmpty(tieuSuBenhTat)) {
                    log.warn("Invalid id data in update request " + new ObjectMapper().writeValueAsString(tieuSuBenhTatDTO));
                    return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid tieuSuBenhTatID"));
                }
            }
        } catch (Exception e) {
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
        tieuSuBenhTat.setMucDo(mucDo);
        tieuSuBenhTat.setPhuongPhapDieuTri(phuongPhapDieuTri);
        tieuSuBenhTat.setLoaiBenh(tieuSuBenhTatDTO.getLoaiBenh());
        tieuSuBenhTat.setBienChung(tieuSuBenhTatDTO.getBienChung());
        tieuSuBenhTat.setBenhVienDieuTri(tieuSuBenhTat.getBenhVienDieuTri());
        tieuSuBenhTat.setNamPhatHien(tieuSuBenhTatDTO.getNamPhatHien());
        tieuSuBenhTat.setGhiChu(tieuSuBenhTatDTO.getGhiChu());
        try {
            tieuSuBenhTatRepo.save(tieuSuBenhTat);
            return ResponseEntity.ok(CommonUtil.returnMessage("message", "Save/update tieuSuBenhTat successfully"));
        } catch (Exception e) {
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
    }

    @Override
    public ResponseEntity<?> capNhatTieuSuBenhDiTruyen(TieuSuBenhDiTruyenDTO tieuSuBenhDiTruyenDTO, BindingResult bindingResult) {
        HashMap<String, String> errors = ValidationUtil.validationCheckBindingResult(bindingResult);
        if (!CommonUtil.isNullOrEmpty(errors)) {
            log.warn(errors.toString());
            return ResponseEntity.badRequest().body(errors);
        }
        MucDo mucDo;
        SoKham soKham;
        TieuSuBenhDiTruyen tieuSuBenhDiTruyen;
        try {
            soKham = soKhamRepo.findSoKhamByAccountID(tieuSuBenhDiTruyenDTO.getAccountID());
            mucDo = mucDoRepo.findByMucDoID(tieuSuBenhDiTruyenDTO.getMucDoID());
            if (CommonUtil.isNullOrEmpty(soKham) || CommonUtil.isNullOrEmpty(mucDo)) {
                log.warn("Invalid id data in request " + new ObjectMapper().writeValueAsString(tieuSuBenhDiTruyenDTO));
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid data"));
            }
            if (CommonUtil.isNullOrEmpty(tieuSuBenhDiTruyenDTO.getTieuSuBenhDiTruyenID())) {
                tieuSuBenhDiTruyen = new TieuSuBenhDiTruyen();
                tieuSuBenhDiTruyen.setSoKham(soKham);
                tieuSuBenhDiTruyen.setTieuSuBenhDiTruyenID(UUID.randomUUID().toString());
            } else {
                tieuSuBenhDiTruyen = tieuSuBenhDiTruyenRepo.findByTieuSuBenhDiTruyenID(tieuSuBenhDiTruyenDTO.getTieuSuBenhDiTruyenID());
                if (CommonUtil.isNullOrEmpty(tieuSuBenhDiTruyen)) {
                    log.warn("Invalid id data in update request " + new ObjectMapper().writeValueAsString(tieuSuBenhDiTruyenDTO));
                    return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid tieuSuBenhDiTruyenID"));
                }
            }
        } catch (Exception e) {
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
        tieuSuBenhDiTruyen.setMucDo(mucDo);
        tieuSuBenhDiTruyen.setLoaiBenh(tieuSuBenhDiTruyenDTO.getLoaiBenh());
        tieuSuBenhDiTruyen.setThanhVienGiaDinh(tieuSuBenhDiTruyenDTO.getThanhVienGiaDinh());
        tieuSuBenhDiTruyen.setNamPhatHien(tieuSuBenhDiTruyenDTO.getNamPhatHien());
        tieuSuBenhDiTruyen.setGhiChu(tieuSuBenhDiTruyenDTO.getGhiChu());
        try {
            tieuSuBenhDiTruyenRepo.save(tieuSuBenhDiTruyen);
            return ResponseEntity.ok(CommonUtil.returnMessage("message", "Save/update tieuSuBenhDiTruyen successfully"));
        } catch (Exception e) {
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
    }

    @Override
    public ResponseEntity<?> capNhatTieuSuDiUng(TieuSuDiUngDTO tieuSuDiUngDTO, BindingResult bindingResult) {
        HashMap<String, String> errors = ValidationUtil.validationCheckBindingResult(bindingResult);
        if (!CommonUtil.isNullOrEmpty(errors)) {
            log.warn(errors.toString());
            return ResponseEntity.badRequest().body(errors);
        }
        MucDo mucDo;
        SoKham soKham;
        TieuSuDiUng tieuSuDiUng;
        try {
            soKham = soKhamRepo.findSoKhamByAccountID(tieuSuDiUngDTO.getAccountID());
            mucDo = mucDoRepo.findByMucDoID(tieuSuDiUngDTO.getMucDoID());
            if (CommonUtil.isNullOrEmpty(soKham) || CommonUtil.isNullOrEmpty(mucDo)) {
                log.warn("Invalid id data in request " + new ObjectMapper().writeValueAsString(tieuSuDiUngDTO));
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid data"));
            }
            if (CommonUtil.isNullOrEmpty(tieuSuDiUngDTO.getTieuSuDiUngID())) {
                tieuSuDiUng = new TieuSuDiUng();
                tieuSuDiUng.setSoKham(soKham);
                tieuSuDiUng.setTieuSuDiUngID(UUID.randomUUID().toString());
            } else {
                tieuSuDiUng = tieuSuDiUngRepo.findByTieuSuDiUngID(tieuSuDiUngDTO.getTieuSuDiUngID());
                if (CommonUtil.isNullOrEmpty(tieuSuDiUng)) {
                    log.warn("Invalid id data in update request " + new ObjectMapper().writeValueAsString(tieuSuDiUngDTO));
                    return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid tieuSuDiUngID"));
                }
            }
        } catch (Exception e) {
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
        tieuSuDiUng.setMucDo(mucDo);
        tieuSuDiUng.setTacNhan(tieuSuDiUngDTO.getTacNhan());
        tieuSuDiUng.setTrieuChung(tieuSuDiUngDTO.getTrieuChung());
        tieuSuDiUng.setLanCuoiXayRa(tieuSuDiUngDTO.getLanCuoiXayRa());
        tieuSuDiUng.setGhiChu(tieuSuDiUngDTO.getGhiChu());
        try {
            tieuSuDiUngRepo.save(tieuSuDiUng);
            return ResponseEntity.ok(CommonUtil.returnMessage("message", "Save/update tieuSuDiUng successfully"));
        } catch (Exception e) {
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
    }

    @Override
    public ResponseEntity<?> capNhatTieuSuPhauThuat(TieuSuPhauThuatDTO tieuSuPhauThuatDTO, BindingResult bindingResult) {
        HashMap<String, String> errors = ValidationUtil.validationCheckBindingResult(bindingResult);
        if (!CommonUtil.isNullOrEmpty(errors)) {
            log.warn(errors.toString());
            return ResponseEntity.badRequest().body(errors);
        }
        log.info("Cap nhat tieu su phau thuat");
        LyDoPhauThuat lyDoPhauThuat;
        SoKham soKham;
        TieuSuPhauThuat tieuSuPhauThuat;
        MucDo mucDo;
        try {
            soKham = soKhamRepo.findSoKhamByAccountID(tieuSuPhauThuatDTO.getAccountID());
            mucDo = mucDoRepo.findByMucDoID(tieuSuPhauThuatDTO.getMucDoID());
            lyDoPhauThuat = lyDoPhauThuatRepo.findByLyDoPhauThuatID(tieuSuPhauThuatDTO.getLyDoPhauThuatID());

            if (CommonUtil.isNullOrEmpty(soKham) || CommonUtil.isNullOrEmpty(mucDo) || CommonUtil.isNullOrEmpty(lyDoPhauThuat)) {
                log.warn("Invalid id data in request " + new ObjectMapper().writeValueAsString(tieuSuPhauThuatDTO));
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid data"));
            }
            if (CommonUtil.isNullOrEmpty(tieuSuPhauThuatDTO.getTieuSuPhauThuatID())) {
                tieuSuPhauThuat = new TieuSuPhauThuat();
                tieuSuPhauThuat.setSoKham(soKham);
                tieuSuPhauThuat.setTieuSuPhauThuatID(UUID.randomUUID().toString());
            } else {
                tieuSuPhauThuat = tieuSuPhauThuatRepo.findByTieuSuPhauThuatID(tieuSuPhauThuatDTO.getTieuSuPhauThuatID());
                if (CommonUtil.isNullOrEmpty(tieuSuPhauThuat)) {
                    log.warn("Invalid id data in update request " + new ObjectMapper().writeValueAsString(tieuSuPhauThuatDTO));
                    return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid TieuSuPhauThuatID"));
                }
            }
        } catch (Exception e) {
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
        tieuSuPhauThuat.setMucDo(mucDo);
        tieuSuPhauThuat.setLyDoPhauThuat(lyDoPhauThuat);
        tieuSuPhauThuat.setTen(tieuSuPhauThuatDTO.getTen());
        tieuSuPhauThuat.setBenhVienThucHien(tieuSuPhauThuatDTO.getBenhVienThucHien());
        tieuSuPhauThuat.setBienChung(tieuSuPhauThuatDTO.getBienChung());
        tieuSuPhauThuat.setGhiChu(tieuSuPhauThuatDTO.getGhiChu());
        try {
            tieuSuPhauThuatRepo.save(tieuSuPhauThuat);
            return ResponseEntity.ok(CommonUtil.returnMessage("message", "Save/update tieuSuPhauThuat successfully"));
        } catch (Exception e) {
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
    }

    @Override
    public ResponseEntity<?> capNhatTieuSuThuoc(TieuSuThuocDTO tieuSuThuocDTO, BindingResult bindingResult) {
        HashMap<String, String> errors = ValidationUtil.validationCheckBindingResult(bindingResult);
        if (!CommonUtil.isNullOrEmpty(errors)) {
            log.warn(errors.toString());
            return ResponseEntity.badRequest().body(errors);
        }
        TinhTrangSuDung tinhTrangSuDung;
        SoKham soKham;
        TieuSuThuoc tieuSuThuoc;
        LoaiSanPham loaiSanPham;
        try {
            soKham = soKhamRepo.findSoKhamByAccountID(tieuSuThuocDTO.getAccountID());
            tinhTrangSuDung = tinhTrangSuDungRepo.findByTinhTrangSuDungID(tieuSuThuocDTO.getTinhTrangSuDungID());
            loaiSanPham = loaiSanPhamRepo.findByLoaiSanPhamID(tieuSuThuocDTO.getLoaiSanPhamID());

            if (CommonUtil.isNullOrEmpty(soKham) || CommonUtil.isNullOrEmpty(tinhTrangSuDung) ) {
                log.warn("Invalid id data in request " + new ObjectMapper().writeValueAsString(tieuSuThuocDTO));
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid data"));
            }
            if (CommonUtil.isNullOrEmpty(tieuSuThuocDTO.getTieuSuThuocID())) {
                tieuSuThuoc = new TieuSuThuoc();
                tieuSuThuoc.setSoKham(soKham);
                tieuSuThuoc.setTieuSuThuocID(UUID.randomUUID().toString());
            } else {
                tieuSuThuoc = tieuSuThuocRepo.findByTieuSuThuocID(tieuSuThuocDTO.getTieuSuThuocID());
                if (CommonUtil.isNullOrEmpty(tieuSuThuoc)) {
                    log.warn("Invalid id data in update request " + new ObjectMapper().writeValueAsString(tieuSuThuocDTO));
                    return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid tieuSuThuocID"));
                }
            }
        } catch (Exception e) {
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
        tieuSuThuoc.setLoaiSanPham(loaiSanPham);
        tieuSuThuoc.setTinhTrangSuDung(tinhTrangSuDung);
        tieuSuThuoc.setTenThuoc(tieuSuThuocDTO.getTenThuoc());
        tieuSuThuoc.setBatDau(tieuSuThuocDTO.getBatDau());
        tieuSuThuoc.setKetThuc(tieuSuThuocDTO.getKetThuc());
        tieuSuThuoc.setGhiChu(tieuSuThuocDTO.getGhiChu());
        try {
            tieuSuThuocRepo.save(tieuSuThuoc);
            log.info("Save/update tieuSuThuoc successfully");
            return ResponseEntity.ok(CommonUtil.returnMessage("message", "Save/update tieuSuThuoc successfully"));
        } catch (Exception e) {
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
    }

    @Override
    public ResponseEntity<?> capNhatTieuSuLoiSong(TieuSuLoiSongDTO tieuSuLoiSongDTO, BindingResult bindingResult) {
        HashMap<String, String> errors = ValidationUtil.validationCheckBindingResult(bindingResult);
        if (!CommonUtil.isNullOrEmpty(errors)) {
            log.warn(errors.toString());
            return ResponseEntity.badRequest().body(errors);
        }
        LoiSongNguoiBenh loiSongNguoiBenh;
        MoiTruong moiTruong = null;
        try {
            List<ThoiQuen> thoiQuens = thoiQuenRepo.findThoiQuenByIds(tieuSuLoiSongDTO.getThoiQuenLoiSongs());
            if (CommonUtil.isNullOrEmpty(thoiQuens) || thoiQuens.size()!=tieuSuLoiSongDTO.getThoiQuenLoiSongs().size()){
                log.warn("Invalid thoiQuen options");
                return ResponseEntity.badRequest().body("Invalid thoiQuen options");
            }
            loiSongNguoiBenh = loiSongNguoiBenhRepo.findByAccountID(tieuSuLoiSongDTO.getAccountID());
            if (CommonUtil.isNullOrEmpty(loiSongNguoiBenh)){
                log.warn("Invalid tieuSuLoiSong");
                return ResponseEntity.badRequest().body("Invalid tieuSuLoiSong");
            }
            if (!CommonUtil.isNullOrEmpty(tieuSuLoiSongDTO.getMoiTruongID())){
                moiTruong = moiTruongRepo.findByMoiTruongID(tieuSuLoiSongDTO.getMoiTruongID());
            }
            if (!CommonUtil.isNullOrEmpty(tieuSuLoiSongDTO.getThoiQuenLoiSongs())){
                List<ThoiQuenLoiSong> thoiQuenLoiSongs = thoiQuenLoiSongRepo.findByLoiSongNguoiBenhID(loiSongNguoiBenh.getLoiSongNguoiBenhID());
                for (ThoiQuenLoiSong thoiQuenLoiSong: thoiQuenLoiSongs){
                    for (ThoiQuen thoiQuen: thoiQuens){
                        if(thoiQuen.getThoiQuenID() == thoiQuenLoiSong.getThoiQuen().getThoiQuenID()){
                            thoiQuenLoiSongs.remove(thoiQuenLoiSong);
                            thoiQuens.remove(thoiQuen);
                        }
                    }
                }
                List<ThoiQuenLoiSong> thoiQuenLoiSongsAddList = thoiQuens.stream().map(e -> new ThoiQuenLoiSong(UUID.randomUUID().toString(),e,loiSongNguoiBenh)).toList();
                if (!thoiQuenLoiSongs.isEmpty())
                    thoiQuenLoiSongRepo.deleteAll(thoiQuenLoiSongs);
                if (!thoiQuenLoiSongsAddList.isEmpty())
                    thoiQuenLoiSongRepo.saveAll(thoiQuenLoiSongsAddList);
            }
        } catch (Exception e) {
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
        loiSongNguoiBenh.setGhiChu(tieuSuLoiSongDTO.getGhiChu());
        loiSongNguoiBenh.setMoiTruong(moiTruong);
        try {
            loiSongNguoiBenhRepo.save(loiSongNguoiBenh);
            return ResponseEntity.ok(CommonUtil.returnMessage("message", "Save/update tieuSuThuoc successfully"));
        } catch (Exception e) {
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
    }

    @Override
    public ResponseEntity<?> getSoKham(String accountID) {
        if (CommonUtil.isNullOrEmpty(accountID)) {
            log.warn("Invalid accountID");
            return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Internal accountID"));
        }
        SoKhamDTO soKhamDTO = new SoKhamDTO();
        try {
            SoKham soKham = soKhamRepo.findByAccountID(accountID);
            if (CommonUtil.isNullOrEmpty(soKham)) {
                log.warn("Invalid accountID");
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Internal accountID"));
            }
            soKhamDTO.setSoKhamID(soKham.getSoKhamID());
            TaiKhoan taiKhoan = soKham.getTaiKhoan();
            soKhamDTO.setAccountName(taiKhoan.getTen());
            soKhamDTO.setCmndCmt(taiKhoan.getCccdCmt());
            soKhamDTO.setBhyt(soKham.getBhyt());
            soKhamDTO.setSdt(taiKhoan.getSdt());
            soKhamDTO.setEmail(taiKhoan.getEmail());
            soKhamDTO.setNgaySinh(taiKhoan.getNgaySinh());
            soKhamDTO.setGioiTinhID(taiKhoan.getGioiTinh().getGioiTinhID());
            soKhamDTO.setDanTocID(taiKhoan.getDanToc().getDanTocID());
            NguoiGiamHo nguoiGiamHo = soKham.getNguoiGiamHos();
            soKhamDTO.setTenNguoiGiamHo(nguoiGiamHo.getGiamHoID());
            soKhamDTO.setCccdCmtNguoiGiamHo(nguoiGiamHo.getCccdCmt());
            soKhamDTO.setMoiQuanHe(nguoiGiamHo.getMoiQuanHe());
            soKhamDTO.setSdtNguoiGiamHo(nguoiGiamHo.getSdt());

            return ResponseEntity.ok(soKhamDTO);
        } catch (Exception e) {
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
    }

    @Override
    public ResponseEntity<?> getDanhSachTieuSuTheoLoai(String accountID, String type) {
        if (CommonUtil.isNullOrEmpty(accountID) || CommonUtil.isNullOrEmpty(type)) {
            log.warn("Invalid parammeter, accountID: " + accountID + ", type: " + type);
            return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Internal accountID"));
        }
        List<?> tieuSuPreviewDatas;
        try{
            switch (type) {
                case "TieuSuBenhTat" -> tieuSuPreviewDatas = tieuSuBenhTatRepo.findPreviewByAccountID(accountID);
                case "TieuSuBenhDiTruyen" -> tieuSuPreviewDatas = tieuSuBenhDiTruyenRepo.findPreviewByAccountID(accountID);
                case "TieuSuDiUng" -> tieuSuPreviewDatas = tieuSuDiUngRepo.findPreviewByAccountID(accountID);
                case "TieuSuPhauThuat" -> tieuSuPreviewDatas = tieuSuPhauThuatRepo.findPreviewByAccountID(accountID);
                case "TieuSuThuoc" -> tieuSuPreviewDatas = tieuSuThuocRepo.findPreviewByAccountID(accountID);
                default -> {
                    log.warn("Invalid type of tieuSu: " + type);
                    return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid type of tieuSu"));
                }
            }
            return ResponseEntity.ok(tieuSuPreviewDatas);
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body("Internal error from server");
        }
    }

    @Override
    public ResponseEntity<?> deleteTieuSuTheoLoai(String tieuSuID, String type) {
        if (CommonUtil.isNullOrEmpty(tieuSuID) || CommonUtil.isNullOrEmpty(type)) {
            log.warn("Invalid parammeter, tieuSuID: " + tieuSuID + ", type: " + type);
            return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Internal accountID"));
        }
        try {
            switch (type) {
                case "TieuSuBenhTat" -> tieuSuBenhTatRepo.deleteById(tieuSuID);
                case "TieuSuBenhDiTruyen" -> tieuSuBenhDiTruyenRepo.deleteById(tieuSuID);
                case "TieuSuDiUng" -> tieuSuDiUngRepo.deleteById(tieuSuID);
                case "TieuSuPhauThuat" -> tieuSuPhauThuatRepo.deleteById(tieuSuID);
                case "TieuSuThuoc" -> tieuSuThuocRepo.deleteById(tieuSuID);
                default -> {
                    log.warn("Invalid type of tieuSu: " + type);
                    return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid type of tieuSu"));
                }
            }
            log.info("Delete tieuSu with id: "+tieuSuID+", type: "+type);
            return ResponseEntity.ok("Delete tieuSu with id: "+tieuSuID);
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body("Internal error from server");
        }
    }

    @Override
    public ResponseEntity<?> getTieuSuLoiSong(String accountID) {
        if (CommonUtil.isNullOrEmpty(accountID)) {
            log.warn("Invalid parammeter, accountID");
            return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Internal accountID"));
        }
        try {
            TieuSuLoiSongDTO tieuSuLoiSongDTO=loiSongNguoiBenhRepo.findDTOByAccountID(accountID);
            if (CommonUtil.isNullOrEmpty(tieuSuLoiSongDTO)){
                log.warn("TieuSuLoiSong not exit in db");
                return ResponseEntity.internalServerError().body("TieuSuLoiSong not exit in db");
            }
            List<Integer> thoiQuenIDs = thoiQuenLoiSongRepo.findIDByLoiSongNguoiBenhIds(tieuSuLoiSongDTO.getLoiSongNguoiBenhID());
            tieuSuLoiSongDTO.setThoiQuenLoiSongs(thoiQuenIDs);
            return ResponseEntity.ok(tieuSuLoiSongDTO);
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body("Internal error from server");
        }
    }
}