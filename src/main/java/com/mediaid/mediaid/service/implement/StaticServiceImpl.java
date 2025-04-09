package com.mediaid.mediaid.service.implement;

import com.mediaid.mediaid.DTO.staticData.DTOMapper;
import com.mediaid.mediaid.DTO.staticData.FormDangKy.GioiTinhDTO;
import com.mediaid.mediaid.DTO.staticData.FormDangKy.DanTocDTO;
import com.mediaid.mediaid.DTO.staticData.FormDangKy.DuLieuTinhChoFormDangKy;
import com.mediaid.mediaid.DTO.staticData.TieuSuYte.*;
import com.mediaid.mediaid.model.*;
import com.mediaid.mediaid.repository.*;
import com.mediaid.mediaid.service.abstracts.StaticService;
import com.mediaid.mediaid.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class StaticServiceImpl implements StaticService {
    @Autowired
    GenderRepo genderRepo;
    @Autowired
    DanTocRepo danTocRepo;
    @Autowired
    LyDoPhauThuatRepo lyDoPhauThuatRepo;
    @Autowired
    MucDoRepo mucDoRepo;
    @Autowired
    PhuongPhapDieuTriRepo phuongPhapDieuTriRepo;
    @Autowired
    TinhTrangSuDungRepo tinhTrangSuDungRepo;
    @Autowired
    LoaiSanPhamRepo loaiSanPhamRepo;
    @Autowired
    ThoiQuenRepo thoiQuenRepo;
    @Autowired
    MoiTruongRepo moiTruongRepo;

    @Override
    public ResponseEntity<?> getStaticRegistryData() {
        try {
            List<GioiTinh> gioiTinhs = genderRepo.findAll();
            List<DanToc> danTocs = danTocRepo.findAll();

            List<GioiTinhDTO> gioiTinhDTOS = GioiTinhDTO.gioiTinhDTOList(gioiTinhs);
            List<DanTocDTO> danTocDTOS = DanTocDTO.danTocDTOList(danTocs);

            return ResponseEntity.ok(new DuLieuTinhChoFormDangKy(gioiTinhDTOS, danTocDTOS));
        }catch (Exception e){
            log.error(String.valueOf(e));
            return ResponseEntity.internalServerError().body("Fail to get static registry data");
        }
    }

    @Override
    public ResponseEntity<?> getStaticDataForTieuSuYTe() {
        List<LyDoPhauThuatDTO> lyDoPhauThuatDTOS;
        List<PhuongPhapDieuTriDTO> phuongPhapDieuTriDTOS;
        List<MucDoDTO> mucDoDTOS;

        try {
            List<LyDoPhauThuat> lyDoPhauThuats = lyDoPhauThuatRepo.findByStatus(true);
            List<PhuongPhapDieuTri> phuongPhapDieuTris = phuongPhapDieuTriRepo.findByStatus(true);
            List<MucDo> mucDos = mucDoRepo.findByStatus(true);

            DTOMapper<LyDoPhauThuat, LyDoPhauThuatDTO> dtoMapper = new LyDoPhauThuatDTO();
            lyDoPhauThuatDTOS = LyDoPhauThuatDTO.mapEntityListToDTOList(lyDoPhauThuats,dtoMapper);

            DTOMapper<PhuongPhapDieuTri, PhuongPhapDieuTriDTO> phuongPhapDieuTriDTOMapper = new PhuongPhapDieuTriDTO();
            phuongPhapDieuTriDTOS = PhuongPhapDieuTriDTO.mapEntityListToDTOList(phuongPhapDieuTris,phuongPhapDieuTriDTOMapper);

            DTOMapper<MucDo, MucDoDTO> mucDoDTOMapper = new MucDoDTO();
            mucDoDTOS = MucDoDTO.mapEntityListToDTOList(mucDos,mucDoDTOMapper);

            DuLieuTinhTieuSuYTe duLieuTinhTieuSuYTe = new DuLieuTinhTieuSuYTe(lyDoPhauThuatDTOS,phuongPhapDieuTriDTOS,mucDoDTOS);
            return ResponseEntity.ok(duLieuTinhTieuSuYTe);
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Fail to retrieving static data"));
        }
    }

    @Override
    public ResponseEntity<?> getStaticDataForTieuSuThuoc() {
        List<TinhTrangSuDungDTO> tinhTrangSuDungDTOS;
        List<LoaiSanPhamDTO> loaiSanPhamDTOS;

        try {
            List<TinhTrangSuDung> tinhTrangSuDungs = tinhTrangSuDungRepo.findByStatus(true);
            List<LoaiSanPham> loaiSanPhams = loaiSanPhamRepo.findByStatus(true);

            DTOMapper<TinhTrangSuDung, TinhTrangSuDungDTO> tinhTrangSuDungDtoMapper = new TinhTrangSuDungDTO();
            tinhTrangSuDungDTOS = TinhTrangSuDungDTO.mapEntityListToDTOList(tinhTrangSuDungs, tinhTrangSuDungDtoMapper);

            DTOMapper<LoaiSanPham, LoaiSanPhamDTO> loaiSanPhamDtoMapper = new LoaiSanPhamDTO();
            loaiSanPhamDTOS = LoaiSanPhamDTO.mapEntityListToDTOList(loaiSanPhams, loaiSanPhamDtoMapper);

            DuLieuTinhTieuSuYTe duLieuTinhTieuSuYTe = new DuLieuTinhTieuSuYTe(loaiSanPhamDTOS, tinhTrangSuDungDTOS);
            return ResponseEntity.ok(duLieuTinhTieuSuYTe);
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Fail to retrieving static data"));
        }
    }

    @Override
    public ResponseEntity<?> getStaticDataForLoiSong() {
        List<ThoiQuenDTO> thoiQuenDTOS;
        List<MoiTruongDTO> moiTruongDTOS;

        try {
            List<ThoiQuen> thoiQuens = thoiQuenRepo.findByStatus(true);
            List<MoiTruong> moiTruongs = moiTruongRepo.findByStatus(true);

            DTOMapper<ThoiQuen, ThoiQuenDTO> thoiQuenDtoMapper = new ThoiQuenDTO();
            thoiQuenDTOS = ThoiQuenDTO.mapEntityListToDTOList(thoiQuens, thoiQuenDtoMapper);

            DTOMapper<MoiTruong, MoiTruongDTO> moiTruongDtoMapper = new MoiTruongDTO();
            moiTruongDTOS = MoiTruongDTO.mapEntityListToDTOList(moiTruongs, moiTruongDtoMapper);

            DuLieuTinhTieuSuLoiSong duLieuTinhTieuSuLoiSong = new DuLieuTinhTieuSuLoiSong(thoiQuenDTOS, moiTruongDTOS);
            return ResponseEntity.ok(duLieuTinhTieuSuLoiSong);
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Fail to retrieving static data"));
        }
    }

}
