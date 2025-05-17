package com.mediaid.mediaid.util;

import com.mediaid.mediaid.model.*;
import com.mediaid.mediaid.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private final DanTocRepo danTocRepository;
    private final GenderRepo genderRepo;
    private final RoleRepo roleRepo;
    private final LyDoPhauThuatRepo lyDoPhauThuatRepo;
    private final MucDoRepo mucDoRepo;
    private final PhuongPhapDieuTriRepo phuongPhapDieuTriRepo;
    private final LoaiSanPhamRepo loaiSanPhamRepo;
    private final TinhTrangSuDungRepo tinhTrangSuDungRepo;
    private final ThoiQuenRepo thoiQuenRepo;
    private final MoiTruongRepo moiTruongRepo;
    private final CoSoBenhVienRepo coSoBenhVienRepo;
    private final PhanVungCoTheRepo phanVungCoTheRepo;
    private final PhongKhamRepo phongKhamRepo;
    private final TrieuChungCuaBoPhanRepo trieuChungCuaBoPhanRepo;
    private final TrieuChungRepo trieuChungRepo;
    private final BoPhanCoTheRepo boPhanCoTheRepo;
    private final ChanDoanBangPhanVungRepo chanDoanBangPhanVungRepo;
    private final MauPhanLoaiKhamRepo mauPhanLoaiKhamRepo;
    private final DichVuKhamRepo dichVuKhamRepo;
    private final TrangThaiKhamSoBoRepo trangThaiKhamSoBoRepo;

    private final AccountRepo accountRepo;
    private final BacSiRepo bacSiRepo;
    private final DecodeEncodeUtil decodeEncodeUtil;
    private final SoKhamRepo soKhamRepo;
    private final LichSuKhamRepo lichSuKhamRepo;
    private final LichSuKhamChiTietRepo lichSuKhamChiTietRepo;
    private final PhongKhamChiTietRepo phongKhamChiTietRepo;
    private final LichSuSuDungThuocRepo lichSuSuDungThuocRepo;
    private final NguoiGiamHoRepo nguoiGiamHoRepo;
    private final ChanDoanBangBoPhanRepo chanDoanBangBoPhanRepo;
    private final ChanDoanBangBoPhanVaTrieuChungRepo chanDoanBangBoPhanVaTrieuChungRepo;
    private final LoiSongNguoiBenhRepo loiSongNguoiBenhRepo;


    public DataInitializer(DanTocRepo danTocRepository, GenderRepo genderRepo, RoleRepo roleRepo, LyDoPhauThuatRepo lyDoPhauThuatRepo,
                           MucDoRepo mucDoRepo, PhuongPhapDieuTriRepo phuongPhapDieuTriRepo, LoaiSanPhamRepo loaiSanPhamRepo,
                           TinhTrangSuDungRepo tinhTrangSuDungRepo, ThoiQuenRepo thoiQuenRepo, MoiTruongRepo moiTruongRepo,
                           CoSoBenhVienRepo coSoBenhVienRepo, PhanVungCoTheRepo phanVungCoTheRepo, PhongKhamRepo phongKhamRepo,
                           TrieuChungCuaBoPhanRepo trieuChungCuaBoPhanRepo, TrieuChungRepo trieuChungRepo, BoPhanCoTheRepo boPhanCoTheRepo,
                           ChanDoanBangPhanVungRepo chanDoanBangPhanVungRepo, MauPhanLoaiKhamRepo mauPhanLoaiKhamRepo,
                           DichVuKhamRepo dichVuKhamRepo, TrangThaiKhamSoBoRepo trangThaiKhamSoBoRepo, AccountRepo accountRepo,
                           BacSiRepo bacSiRepo, DecodeEncodeUtil decodeEncodeUtil, SoKhamRepo soKhamRepo, LichSuKhamRepo lichSuKhamRepo,
                           LichSuKhamChiTietRepo lichSuKhamChiTietRepo, PhongKhamChiTietRepo phongKhamChiTietRepo,
                           LichSuSuDungThuocRepo lichSuSuDungThuocRepo, NguoiGiamHoRepo nguoiGiamHoRepo,
                           ChanDoanBangBoPhanRepo chanDoanBangBoPhanRepo, ChanDoanBangBoPhanVaTrieuChungRepo chanDoanBangBoPhanVaTrieuChungRepo,
                           LoiSongNguoiBenhRepo loiSongNguoiBenhRepo) {
        this.danTocRepository = danTocRepository;
        this.genderRepo = genderRepo;
        this.roleRepo = roleRepo;
        this.lyDoPhauThuatRepo = lyDoPhauThuatRepo;
        this.mucDoRepo = mucDoRepo;
        this.phuongPhapDieuTriRepo = phuongPhapDieuTriRepo;
        this.loaiSanPhamRepo = loaiSanPhamRepo;
        this.tinhTrangSuDungRepo = tinhTrangSuDungRepo;
        this.thoiQuenRepo = thoiQuenRepo;
        this.moiTruongRepo = moiTruongRepo;
        this.coSoBenhVienRepo = coSoBenhVienRepo;
        this.phanVungCoTheRepo = phanVungCoTheRepo;
        this.phongKhamRepo = phongKhamRepo;
        this.trieuChungCuaBoPhanRepo = trieuChungCuaBoPhanRepo;
        this.trieuChungRepo = trieuChungRepo;
        this.boPhanCoTheRepo = boPhanCoTheRepo;
        this.chanDoanBangPhanVungRepo = chanDoanBangPhanVungRepo;
        this.mauPhanLoaiKhamRepo = mauPhanLoaiKhamRepo;
        this.dichVuKhamRepo = dichVuKhamRepo;
        this.trangThaiKhamSoBoRepo = trangThaiKhamSoBoRepo;
        this.accountRepo = accountRepo;
        this.bacSiRepo = bacSiRepo;
        this.decodeEncodeUtil = decodeEncodeUtil;
        this.soKhamRepo = soKhamRepo;
        this.lichSuKhamRepo = lichSuKhamRepo;
        this.lichSuKhamChiTietRepo = lichSuKhamChiTietRepo;
        this.phongKhamChiTietRepo = phongKhamChiTietRepo;
        this.lichSuSuDungThuocRepo = lichSuSuDungThuocRepo;
        this.nguoiGiamHoRepo = nguoiGiamHoRepo;
        this.chanDoanBangBoPhanRepo = chanDoanBangBoPhanRepo;
        this.chanDoanBangBoPhanVaTrieuChungRepo = chanDoanBangBoPhanVaTrieuChungRepo;
        this.loiSongNguoiBenhRepo = loiSongNguoiBenhRepo;
    }

    @Override
    public void run(String... args) {
        // Check if data already exists
        if (danTocRepository.count() == 0) {
            List<DanToc> danTocList = List.of(
                    new DanToc("Kinh"),
                    new DanToc("Tày"),
                    new DanToc("Thái"),
                    new DanToc("Mường"),
                    new DanToc("H'Mông"),
                    new DanToc("Nùng"),
                    new DanToc("Hoa"),
                    new DanToc("Khơ Me"),
                    new DanToc("Dao"),
                    new DanToc("Gia Rai"),
                    new DanToc("Ê Đê"),
                    new DanToc("Ba Na"),
                    new DanToc("Xơ Đăng"),
                    new DanToc("Sán Chay"),
                    new DanToc("Cơ Ho"),
                    new DanToc("Chăm"),
                    new DanToc("Sán Dìu"),
                    new DanToc("Hrê"),
                    new DanToc("Mnông"),
                    new DanToc("Ra Glai"),
                    new DanToc("Thổ"),
                    new DanToc("Stiêng"),
                    new DanToc("Kháng"),
                    new DanToc("X’Tiêng"),
                    new DanToc("Bru - Vân Kiều"),
                    new DanToc("Cơ Tu"),
                    new DanToc("Giáy"),
                    new DanToc("Tà Ôi"),
                    new DanToc("Mạ"),
                    new DanToc("Co"),
                    new DanToc("Chơ Ro"),
                    new DanToc("Xinh Mun"),
                    new DanToc("Hà Nhì"),
                    new DanToc("Chu Ru"),
                    new DanToc("Lào"),
                    new DanToc("La Chí"),
                    new DanToc("La Ha"),
                    new DanToc("Phù Lá"),
                    new DanToc("La Hủ"),
                    new DanToc("Lự"),
                    new DanToc("Lô Lô"),
                    new DanToc("Chứt"),
                    new DanToc("Mảng"),
                    new DanToc("Pà Thẻn"),
                    new DanToc("Co Lao"),
                    new DanToc("Cống"),
                    new DanToc("Bố Y"),
                    new DanToc("Si La"),
                    new DanToc("Pu Péo"),
                    new DanToc("Brâu"),
                    new DanToc("Ơ Đu"),
                    new DanToc("Rơ Măm"),
                    new DanToc("Ngái"),
                    new DanToc("Cống")
            );
            danTocRepository.saveAll(danTocList);
            log.info("Inserted default DanToc data into the database.");
        }
        if (genderRepo.count() == 0) {
            List<GioiTinh> genderList = List.of(
                    new GioiTinh("Nam"),
                    new GioiTinh("Nữ"),
                    new GioiTinh("Khác")
            );
            genderRepo.saveAll(genderList);
            log.info("Inserted default GioiTinh data into the database.");
        }
        if (roleRepo.count() ==0){
            List<Role> roleList = List.of(
                    new Role("Bệnh nhân"),
                    new Role("Bác sĩ")
             );
            roleRepo.saveAll(roleList);
            log.info("Insert default Role data into the database.");
        }
        if (phuongPhapDieuTriRepo.count() ==0){
            List<PhuongPhapDieuTri> phuongPhapDieuTriList = List.of(
                    new PhuongPhapDieuTri("Điều trị nội khoa (dùng thuốc)", true),
                    new PhuongPhapDieuTri("Điều trị phẫu thuật", true),
                    new PhuongPhapDieuTri("Điều trị bằng liệu pháp vật lý", true),
                    new PhuongPhapDieuTri("Điều trị tâm lý", true),
                    new PhuongPhapDieuTri("Điều trị bằng dinh dưỡng", true),
                    new PhuongPhapDieuTri("Điều trị bằng vật lý và các phương pháp thay thế", true),
                    new PhuongPhapDieuTri("Điều trị bằng liệu pháp hormon", true),
                    new PhuongPhapDieuTri("Điều trị bằng phóng xạ (xạ trị)", true),
                    new PhuongPhapDieuTri("Điều trị bằng truyền máu", true),
                    new PhuongPhapDieuTri("Điều trị bằng các phương pháp chăm sóc đặc biệt", true),
                    new PhuongPhapDieuTri("Điều trị bằng liệu pháp miễn dịch", true),
                    new PhuongPhapDieuTri("Điều trị thay thế cơ quan", true)
            );
            phuongPhapDieuTriRepo.saveAll(phuongPhapDieuTriList);
            log.info("Insert default PhuongPhapDieuTri data into the database.");
        }
        if (lyDoPhauThuatRepo.count() ==0){
            List<LyDoPhauThuat> lyDoPhauThuatList = List.of(
                    new LyDoPhauThuat("Điều trị bệnh lý", true),
                    new LyDoPhauThuat("Cấp cứu", true),
                    new LyDoPhauThuat("Chỉnh hình", true),
                    new LyDoPhauThuat("Phẫu thuật thẩm mỹ", true),
                    new LyDoPhauThuat("Phẫu thuật nội soi", true),
                    new LyDoPhauThuat("Cải thiện chức năng", true),
                    new LyDoPhauThuat("Điều trị nhiễm trùng", true),
                    new LyDoPhauThuat("Chẩn đoán", true),
                    new LyDoPhauThuat("Điều trị bệnh lý thần kinh", true),
                    new LyDoPhauThuat("Phẫu thuật giảm đau", true),
                    new LyDoPhauThuat("Phẫu thuật giảm cân (Phẫu thuật bariatric)", true),
                    new LyDoPhauThuat("Phẫu thuật điều trị ung thư", true)
            );
            lyDoPhauThuatRepo.saveAll(lyDoPhauThuatList);
            log.info("Insert default LyDoPhauThuat data into the database.");
        }
        if (mucDoRepo.count() ==0){
            List<MucDo> mucDoList = List.of(
                    new MucDo("Nhẹ", true),
                    new MucDo("Vừa", true),
                    new MucDo("Nặng", true)
                    );
            mucDoRepo.saveAll(mucDoList);
            log.info("Insert default MucDo data into the database.");
        }
        if (loaiSanPhamRepo.count() == 0){
            List<LoaiSanPham> loaiSanPhams = List.of(
                    new LoaiSanPham("Thuốc kê đơn", true),
                    new LoaiSanPham("Thuốc không kê đơn", true),
                    new LoaiSanPham("Thực phẩm chức năng" , true)
                    );
            loaiSanPhamRepo.saveAll(loaiSanPhams);
            log.info("Insert default loaiSanPham data into the database.");
        }
        if (tinhTrangSuDungRepo.count() == 0){
            List<TinhTrangSuDung> tinhTrangSuDungs = List.of(
                    new TinhTrangSuDung("Đang sử dụng", true),
                    new TinhTrangSuDung("Đã sử dụng xong 1 - 2 tháng trước", true),
                    new TinhTrangSuDung("Đã từng sử dụng trong thời gian dài", true)
                    );
            tinhTrangSuDungRepo.saveAll(tinhTrangSuDungs);
            log.info("Insert default tinhTrangSuDungs data into the database.");
        }
        if(thoiQuenRepo.count() == 0){
            List<ThoiQuen> thoiQuens = List.of(
                    new ThoiQuen("Sử dụng chất kích thích \n" + "(thuốc lá, ma túy, thuốc lá điện tử)", true),
                    new ThoiQuen("Uống nhiều rượu bia", true),
                    new ThoiQuen("Ăn mặn", true),
                    new ThoiQuen("Stress tâm lý", true),
                    new ThoiQuen("Thường xuyên thiếu ngủ", true),
                    new ThoiQuen("Ít vận động thể dục hoặc ngồi nhiều", true)
                    );
            thoiQuenRepo.saveAll(thoiQuens);
            log.info("Insert default thoiQuens data into the database.");
        }
        if(moiTruongRepo.count() == 0){
            List<MoiTruong> moiTruongs = List.of(
                    new MoiTruong("Văn phòng ngồi nhiều", true),
                    new MoiTruong("Công trường / Lao động tay chân nặng", true),
                    new MoiTruong("Đứng lâu (bán hàng, giáo viên...)", true),
                    new MoiTruong("Di chuyển liên tục (giao hàng, kỹ thuật viên...)", true),
                    new MoiTruong("Môi trường tiếp xúc hóa chất / bụi / độc hại", true),
                    new MoiTruong("Áp lực công việc cao", true),
                    new MoiTruong("Ít tương tác xã hội / cô lập", true),
                    new MoiTruong("Làm việc ca đêm / theo ca", true)
            );
            moiTruongRepo.saveAll(moiTruongs);
            log.info("Insert default moiTruongs data into the database.");
        }
        if(mauPhanLoaiKhamRepo.count()==0){
            List<MauLoaiKham> mauLoaiKhams = List.of(
                    new MauLoaiKham("Green", "Chẩn đoán hình ảnh"),
                    new MauLoaiKham("Red", "Thủ thuật y tế và can thiệp"),
                    new MauLoaiKham("Yellow", "Xét nghệm chức năng"),
                    new MauLoaiKham("Blue","Chẩn đoán sơ bộ")
            );
            mauLoaiKhams = mauPhanLoaiKhamRepo.saveAll(mauLoaiKhams);
            List<DichVuKham> dichVuKhams = List.of(
                    new DichVuKham("Siêu âm", 100000.0,true, mauLoaiKhams.get(0)),
                    new DichVuKham("Chụp XQuang (thường + số hóa)", 100000.0,true, mauLoaiKhams.get(0)),
                    new DichVuKham("Chụp cắt lớp vi tính, chụp mạch và chụp cộng hưởng từ", 100000.0,true, mauLoaiKhams.get(0)),

                    new DichVuKham("Chọc tế bào", 100000.0,true, mauLoaiKhams.get(1)),
                    new DichVuKham("Sinh thiết", 100000.0,true, mauLoaiKhams.get(1)),
                    new DichVuKham("nội soi", 100000.0,true, mauLoaiKhams.get(1)),

                    new DichVuKham("Xét nghiệm máu", 100000.0,true, mauLoaiKhams.get(2)),
                    new DichVuKham("Xét nghiệm nước tiểu", 100000.0,true, mauLoaiKhams.get(2)),
                    new DichVuKham("Xét nghiệm vi khuẩn, Virus", 100000.0,true, mauLoaiKhams.get(2)),
                    new DichVuKham("Điện tim", 100000.0,true, mauLoaiKhams.get(2)),
                    new DichVuKham("Đo mật độ xương", 100000.0,true, mauLoaiKhams.get(2)),
                    new DichVuKham("Đo chức năng hô hấp", 100000.0,true, mauLoaiKhams.get(2)),
                    new DichVuKham("Test dị ứng", 100000.0,true, mauLoaiKhams.get(2)),

                    new DichVuKham("Chẩn đoán sơ bộ", 100000.0,true, mauLoaiKhams.get(3))
            );
            dichVuKhamRepo.saveAll(dichVuKhams);
        }
        if(coSoBenhVienRepo.count() == 0 || phongKhamRepo.count() ==0){
            CoSoBenhVien coSoBenhVien1 = new CoSoBenhVien(1, "Cơ sở K Tân Triều", "30 Đ. Cầu Bươu, Tân Triều, Thanh Trì, Hà Nội");
            DichVuKham dichVuKham = dichVuKhamRepo.findById(14).get();
            coSoBenhVien1 = coSoBenhVienRepo.save(coSoBenhVien1);
            List<PhongKham> phongKhams = List.of(
                    new PhongKham("pk_1", "Ngoại Phụ khoa", true, true, dichVuKham),
                    new PhongKham("pk_2", "Ngoại Vú", true, true, dichVuKham),
                    new PhongKham("pk_3", "Tim mạch", true, true, dichVuKham),
                    new PhongKham("pk_4", "Đầu mặt cổ", true, true, dichVuKham),
                    new PhongKham("pk_5", "Tiết niệu", true, true, dichVuKham),
                    new PhongKham("pk_6", "Gan mật", true, true, dichVuKham),
                    new PhongKham("pk_7", "Nội", true, true, dichVuKham),
                    new PhongKham("pk_8", "Ngoại thần kinh", true, true, dichVuKham),
                    new PhongKham("pk_9", "Lồng ngực", true, true, dichVuKham),
                    new PhongKham("pk_10", "Chuyên khoa", true, true, dichVuKham),
                    new PhongKham("pk_11", "Tổng hợp", true, true, dichVuKham),
                    new PhongKham("pk_12", "Cơ xương khớp", true, true, dichVuKham),
                    new PhongKham("pk_13", "Siêu âm", true, true, dichVuKhamRepo.findById(1).get()),
                    new PhongKham("pk_14", "Nội soi", true, true, dichVuKhamRepo.findById(6).get())
            );
            phongKhams = phongKhamRepo.saveAll(phongKhams);

            List<PhongKhamChiTiet> phongKhamChiTietsPk1 = List.of(
                    new PhongKhamChiTiet("pkct1","1_pk1_ct01",70,true, phongKhams.get(0), coSoBenhVien1),
                    new PhongKhamChiTiet("pkct2","1_pk1_ct02",70,true, phongKhams.get(0), coSoBenhVien1)
            );
            phongKhams.get(0).setPhongKhamChiTiets(phongKhamChiTietsPk1);
            List<PhongKhamChiTiet> phongKhamChiTietsAddALl = new ArrayList<>(phongKhamChiTietsPk1);

            List<PhongKhamChiTiet> phongKhamChiTietsPk2 = List.of(
                    new PhongKhamChiTiet("pkct3","1_pk2_ct01",70,true, phongKhams.get(1), coSoBenhVien1),
                    new PhongKhamChiTiet("pkct4","1_pk2_ct02",70,true, phongKhams.get(1), coSoBenhVien1)
            );
            phongKhams.get(1).setPhongKhamChiTiets(phongKhamChiTietsPk2);
            phongKhamChiTietsAddALl.addAll(phongKhamChiTietsPk2);

            List<PhongKhamChiTiet> phongKhamChiTietsPk3 = List.of(
                    new PhongKhamChiTiet("pkct5","1_pk3_ct01",70,true, phongKhams.get(2), coSoBenhVien1),
                    new PhongKhamChiTiet("pkct6","1_pk3_ct02",70,true, phongKhams.get(2), coSoBenhVien1)
            );
            phongKhams.get(2).setPhongKhamChiTiets(phongKhamChiTietsPk3);
            phongKhamChiTietsAddALl.addAll(phongKhamChiTietsPk3);

            List<PhongKhamChiTiet> phongKhamChiTietsPk4 = List.of(
                    new PhongKhamChiTiet("pkct7","1_pk4_ct01",70,true, phongKhams.get(3), coSoBenhVien1),
                    new PhongKhamChiTiet("pkct8","1_pk4_ct02",70,true, phongKhams.get(3), coSoBenhVien1)
            );
            phongKhams.get(3).setPhongKhamChiTiets(phongKhamChiTietsPk4);
            phongKhamChiTietsAddALl.addAll(phongKhamChiTietsPk4);

            List<PhongKhamChiTiet> phongKhamChiTietsPk5 = List.of(
                    new PhongKhamChiTiet("pkct9","1_pk5_ct01",70,true, phongKhams.get(4), coSoBenhVien1)
            );
            phongKhams.get(4).setPhongKhamChiTiets(phongKhamChiTietsPk5);
            phongKhamChiTietsAddALl.addAll(phongKhamChiTietsPk5);

            List<PhongKhamChiTiet> phongKhamChiTietsPk6 = List.of(
                    new PhongKhamChiTiet("pkct10","1_pk6_ct01",70,true, phongKhams.get(5), coSoBenhVien1)
            );
            phongKhams.get(5).setPhongKhamChiTiets(phongKhamChiTietsPk6);
            phongKhamChiTietsAddALl.addAll(phongKhamChiTietsPk6);

            List<PhongKhamChiTiet> phongKhamChiTietsPk7 = List.of(
                    new PhongKhamChiTiet("pkct11","1_pk7_ct01",70,true, phongKhams.get(6),coSoBenhVien1)
            );
            phongKhams.get(6).setPhongKhamChiTiets(phongKhamChiTietsPk7);
            phongKhamChiTietsAddALl.addAll(phongKhamChiTietsPk7);

            List<PhongKhamChiTiet> phongKhamChiTietsPk8 = List.of(
                    new PhongKhamChiTiet("pkct12","1_pk8_ct01",70,true, phongKhams.get(7),coSoBenhVien1)
            );
            phongKhams.get(7).setPhongKhamChiTiets(phongKhamChiTietsPk8);
            phongKhamChiTietsAddALl.addAll(phongKhamChiTietsPk8);

            List<PhongKhamChiTiet> phongKhamChiTietsPk9 = List.of(
                    new PhongKhamChiTiet("pkct13","1_pk9_ct01",70,true, phongKhams.get(8),coSoBenhVien1)
            );
            phongKhams.get(8).setPhongKhamChiTiets(phongKhamChiTietsPk9);
            phongKhamChiTietsAddALl.addAll(phongKhamChiTietsPk9);

            List<PhongKhamChiTiet> phongKhamChiTietsPk10 = List.of(
                    new PhongKhamChiTiet("pkct14","1_pk10_ct01",70,true, phongKhams.get(9),coSoBenhVien1)
            );
            phongKhams.get(9).setPhongKhamChiTiets(phongKhamChiTietsPk10);
            phongKhamChiTietsAddALl.addAll(phongKhamChiTietsPk10);

            List<PhongKhamChiTiet> phongKhamChiTietsPk11 = List.of(
                    new PhongKhamChiTiet("pkct15","1_pk11_ct01",70,true, phongKhams.get(10),coSoBenhVien1),
                    new PhongKhamChiTiet("pkct16","1_pk11_ct02",70,true, phongKhams.get(10),coSoBenhVien1)
            );
            phongKhams.get(10).setPhongKhamChiTiets(phongKhamChiTietsPk11);
            phongKhamChiTietsAddALl.addAll(phongKhamChiTietsPk11);

            List<PhongKhamChiTiet> phongKhamChiTietsPk12 = List.of(
                    new PhongKhamChiTiet("pkct17","1_pk12_ct01",70,true, phongKhams.get(11),coSoBenhVien1),
                    new PhongKhamChiTiet("pkct18","1_pk12_ct02",70,true, phongKhams.get(11),coSoBenhVien1),
                    new PhongKhamChiTiet("pkct19","1_pk12_ct03",70,true, phongKhams.get(11),coSoBenhVien1)
            );
            phongKhams.get(11).setPhongKhamChiTiets(phongKhamChiTietsPk12);
            phongKhamChiTietsAddALl.addAll(phongKhamChiTietsPk12);

            List<PhongKhamChiTiet> phongKhamChiTietsPk13 = List.of(
                    new PhongKhamChiTiet("pkct20","1_pk13_ct01",70,true, phongKhams.get(12),coSoBenhVien1),
                    new PhongKhamChiTiet("pkct21","1_pk13_ct02",70,true, phongKhams.get(12),coSoBenhVien1)
            );
            phongKhams.get(12).setPhongKhamChiTiets(phongKhamChiTietsPk13);
            phongKhamChiTietsAddALl.addAll(phongKhamChiTietsPk13);

            List<PhongKhamChiTiet> phongKhamChiTietsPk14 = List.of(
                    new PhongKhamChiTiet("pkct22","1_pk14_ct01",70,true, phongKhams.get(13),coSoBenhVien1),
                    new PhongKhamChiTiet("pkct23","1_pk14_ct02",70,true, phongKhams.get(13),coSoBenhVien1)
            );
            phongKhams.get(13).setPhongKhamChiTiets(phongKhamChiTietsPk14);
            phongKhamChiTietsAddALl.addAll(phongKhamChiTietsPk14);

            coSoBenhVien1.setPhongKhamChiTiets(phongKhamChiTietsAddALl);
            phongKhams = phongKhamRepo.saveAll(phongKhams);
            coSoBenhVienRepo.save(coSoBenhVien1);
            log.info("Insert default coSoBenhViens data into the database.");


            CoSoBenhVien coSoBenhVien2 = new CoSoBenhVien(2, "Cơ sở K Quán Sứ", "Số 43 Quán Sứ, Hoàn Kiếm, Hà Nội");
            coSoBenhVien2 = coSoBenhVienRepo.save(coSoBenhVien2);
            List<PhongKhamChiTiet> phongKhamChiTietsPk15 = List.of(
                    new PhongKhamChiTiet("pkct24","2_pk1_ct01",70,true, phongKhams.get(0), coSoBenhVien2),
                    new PhongKhamChiTiet("pkct25","2_pk1_ct02",70,true, phongKhams.get(0), coSoBenhVien2)
            );
            phongKhams.get(0).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk15);
            List<PhongKhamChiTiet> phongKhamChiTietsAddALl1 = new ArrayList<>(phongKhamChiTietsPk15);

            List<PhongKhamChiTiet> phongKhamChiTietsPk16 = List.of(
                    new PhongKhamChiTiet("pkct26","2_pk2_ct01",70,true, phongKhams.get(1), coSoBenhVien2),
                    new PhongKhamChiTiet("pkct27","2_pk2_ct02",70,true, phongKhams.get(1), coSoBenhVien2)
            );
            phongKhams.get(1).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk16);
            phongKhamChiTietsAddALl1.addAll(phongKhamChiTietsPk16);

            List<PhongKhamChiTiet> phongKhamChiTietsPk17 = List.of(
                    new PhongKhamChiTiet("pkct28","2_pk3_ct01",70,true, phongKhams.get(2), coSoBenhVien2),
                    new PhongKhamChiTiet("pkct29","2_pk3_ct02",70,true, phongKhams.get(2), coSoBenhVien2)
            );
            phongKhams.get(2).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk17);
            phongKhamChiTietsAddALl1.addAll(phongKhamChiTietsPk17);

            List<PhongKhamChiTiet> phongKhamChiTietsPk18 = List.of(
                    new PhongKhamChiTiet("pkct30","2_pk4_ct01",70,true, phongKhams.get(3), coSoBenhVien2),
                    new PhongKhamChiTiet("pkct31","2_pk4_ct02",70,true, phongKhams.get(3), coSoBenhVien2)
            );
            phongKhams.get(3).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk18);
            phongKhamChiTietsAddALl1.addAll(phongKhamChiTietsPk18);

            List<PhongKhamChiTiet> phongKhamChiTietsPk19 = List.of(
                    new PhongKhamChiTiet("pkct32","2_pk5_ct01",70,true, phongKhams.get(4), coSoBenhVien2)
            );
            phongKhams.get(4).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk19);
            phongKhamChiTietsAddALl1.addAll(phongKhamChiTietsPk19);

            List<PhongKhamChiTiet> phongKhamChiTietsPk20 = List.of(
                    new PhongKhamChiTiet("pkct33","2_pk6_ct01",70,true, phongKhams.get(5), coSoBenhVien2)
            );
            phongKhams.get(5).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk20);
            phongKhamChiTietsAddALl1.addAll(phongKhamChiTietsPk20);

            List<PhongKhamChiTiet> phongKhamChiTietsPk21 = List.of(
                    new PhongKhamChiTiet("pkct34","2_pk7_ct01",70,true, phongKhams.get(6),coSoBenhVien2)
            );
            phongKhams.get(6).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk21);
            phongKhamChiTietsAddALl1.addAll(phongKhamChiTietsPk21);

            List<PhongKhamChiTiet> phongKhamChiTietsPk22 = List.of(
                    new PhongKhamChiTiet("pkct35","2_pk8_ct01",70,true, phongKhams.get(7),coSoBenhVien2)
            );
            phongKhams.get(7).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk22);
            phongKhamChiTietsAddALl1.addAll(phongKhamChiTietsPk22);

            List<PhongKhamChiTiet> phongKhamChiTietsPk23 = List.of(
                    new PhongKhamChiTiet("pkct36","2_pk9_ct01",70,true, phongKhams.get(8),coSoBenhVien2)
            );
            phongKhams.get(8).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk23);
            phongKhamChiTietsAddALl1.addAll(phongKhamChiTietsPk23);

            List<PhongKhamChiTiet> phongKhamChiTietsPk24 = List.of(
                    new PhongKhamChiTiet("pkct37","2_pk10_ct01",70,true, phongKhams.get(9),coSoBenhVien2)
            );
            phongKhams.get(9).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk24);
            phongKhamChiTietsAddALl1.addAll(phongKhamChiTietsPk24);

            List<PhongKhamChiTiet> phongKhamChiTietsPk25 = List.of(
                    new PhongKhamChiTiet("pkct38","2_pk11_ct01",70,true, phongKhams.get(10),coSoBenhVien2),
                    new PhongKhamChiTiet("pkct39","2_pk11_ct02",70,true, phongKhams.get(10),coSoBenhVien2)
            );
            phongKhams.get(10).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk25);
            phongKhamChiTietsAddALl1.addAll(phongKhamChiTietsPk25);

            List<PhongKhamChiTiet> phongKhamChiTietsPk26 = List.of(
                    new PhongKhamChiTiet("pkct40","2_pk12_ct01",70,true, phongKhams.get(11),coSoBenhVien2),
                    new PhongKhamChiTiet("pkct41","2_pk12_ct02",70,true, phongKhams.get(11),coSoBenhVien2),
                    new PhongKhamChiTiet("pkct42","2_pk12_ct03",70,true, phongKhams.get(11),coSoBenhVien2)
            );
            phongKhams.get(11).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk26);
            phongKhamChiTietsAddALl1.addAll(phongKhamChiTietsPk26);

            List<PhongKhamChiTiet> phongKhamChiTietsPk27 = List.of(
                    new PhongKhamChiTiet("pkct43","2_pk13_ct01",70,true, phongKhams.get(12),coSoBenhVien2),
                    new PhongKhamChiTiet("pkct44","2_pk13_ct02",70,true, phongKhams.get(12),coSoBenhVien2)
            );
            phongKhams.get(12).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk27);
            phongKhamChiTietsAddALl1.addAll(phongKhamChiTietsPk27);

            List<PhongKhamChiTiet> phongKhamChiTietsPk28 = List.of(
                    new PhongKhamChiTiet("pkct45","2_pk14_ct01",70,true, phongKhams.get(13),coSoBenhVien2),
                    new PhongKhamChiTiet("pkct46","2_pk14_ct02",70,true, phongKhams.get(13),coSoBenhVien2)
            );
            phongKhams.get(13).getPhongKhamChiTiets().addAll(phongKhamChiTietsPk28);
            phongKhamChiTietsAddALl1.addAll(phongKhamChiTietsPk28);

            phongKhamChiTietsAddALl1 = phongKhamChiTietRepo.saveAll(phongKhamChiTietsAddALl1);

            coSoBenhVien2.setPhongKhamChiTiets(phongKhamChiTietsAddALl1);
            phongKhamRepo.saveAll(phongKhams);
            coSoBenhVienRepo.save(coSoBenhVien2);
            log.info("Insert default coSoBenhViens data into the database.");


        }
        if (phanVungCoTheRepo.count() == 0){
            List<PhanVungCoThe> phanVungCoThes = List.of(
                    new PhanVungCoThe("pv_1", "Đầu", true),
                    new PhanVungCoThe("pv_2", "Da", true),
                    new PhanVungCoThe("pv_3", "Cổ", true),
                    new PhanVungCoThe("pv_4", "Ngực", true),
                    new PhanVungCoThe("pv_5", "Tay", true),
                    new PhanVungCoThe("pv_6", "Bụng", true),
                    new PhanVungCoThe("pv_7", "Xương chậu", true),
                    new PhanVungCoThe("pv_8", "Lưng", true),
                    new PhanVungCoThe("pv_9", "Mông", true),
                    new PhanVungCoThe("pv_10", "Chân", true)
            );
            phanVungCoThes = phanVungCoTheRepo.saveAll(phanVungCoThes);

//            List<PhanVungCoThe> phanVungCoThes = phanVungCoTheRepo.findAllAndOrder();
            List<PhongKham> phongKhams = phongKhamRepo.findAllAndOrder();
            List<ChanDoanBangPhanVung> chanDoanBangPhanVungs = List.of(
                    new ChanDoanBangPhanVung(UUID.randomUUID().toString(),phanVungCoThes.get(4),phongKhams.get(9)),
                    new ChanDoanBangPhanVung(UUID.randomUUID().toString(),phanVungCoThes.get(4),phongKhams.get(11)),

                    new ChanDoanBangPhanVung(UUID.randomUUID().toString(),phanVungCoThes.get(9),phongKhams.get(9)),
                    new ChanDoanBangPhanVung(UUID.randomUUID().toString(),phanVungCoThes.get(9),phongKhams.get(11)),

                    new ChanDoanBangPhanVung(UUID.randomUUID().toString(),phanVungCoThes.get(8),phongKhams.get(9)),
                    new ChanDoanBangPhanVung(UUID.randomUUID().toString(),phanVungCoThes.get(8),phongKhams.get(11)),

                    new ChanDoanBangPhanVung(UUID.randomUUID().toString(),phanVungCoThes.get(1),phongKhams.get(6)),
                    new ChanDoanBangPhanVung(UUID.randomUUID().toString(),phanVungCoThes.get(1),phongKhams.get(9)),
                    new ChanDoanBangPhanVung(UUID.randomUUID().toString(),phanVungCoThes.get(1),phongKhams.get(10))
            );
            chanDoanBangPhanVungRepo.saveAll(chanDoanBangPhanVungs);

            List<BoPhanCoThe> boPhanCoThes1 = List.of(
                    new BoPhanCoThe("bp_1", "Sau đầu", true, phanVungCoThes.get(0),null),
                    new BoPhanCoThe("bp_2", "Da đầu", true, phanVungCoThes.get(0),null),
                    new BoPhanCoThe("bp_3", "Trán", true, phanVungCoThes.get(0),null),
                    new BoPhanCoThe("bp_4", "Mắt", true, phanVungCoThes.get(0),null),
                    new BoPhanCoThe("bp_5", "Mũi", true, phanVungCoThes.get(0),null),
                    new BoPhanCoThe("bp_6", "Miệng", true, phanVungCoThes.get(0),null),
                    new BoPhanCoThe("bp_7", "Hàm", true, phanVungCoThes.get(0),null),
                    new BoPhanCoThe("bp_8", "Tai", true, phanVungCoThes.get(0),null)
            );
            phanVungCoThes.get(0).setBoPhanCoThes(boPhanCoThes1);
            List<BoPhanCoThe> boPhanCoThes3 = List.of(
                    new BoPhanCoThe("bp_9", "Trước cổ", true, phanVungCoThes.get(2),null),
                    new BoPhanCoThe("bp_10", "Sau gáy", true, phanVungCoThes.get(2),null)
                    );
            phanVungCoThes.get(2).setBoPhanCoThes(boPhanCoThes3);
            List<BoPhanCoThe> boPhanCoThes4 = List.of(
                    new BoPhanCoThe("bp_11", "Ngực trên", true, phanVungCoThes.get(3),null),
                    new BoPhanCoThe("bp_12", "Khung xương ngực (Xương ức, Xương sườn, Cột sống ngực)", true, phanVungCoThes.get(3),null),
                    new BoPhanCoThe("bp_13", "Tim", true, phanVungCoThes.get(3),null),
                    new BoPhanCoThe("bp_14", "Vú", true, phanVungCoThes.get(3),genderRepo.findByGioiTinhID(1)),
                    new BoPhanCoThe("bp_15", "Vú", true, phanVungCoThes.get(3),genderRepo.findByGioiTinhID(2))
                    );
            phanVungCoThes.get(3).setBoPhanCoThes(boPhanCoThes4);
            List<BoPhanCoThe> boPhanCoThes6 = List.of(
                    new BoPhanCoThe("bp_16", "Thượng vị (Trên trung tâm bụng) + Bụng trên", true, phanVungCoThes.get(5),null),
                    new BoPhanCoThe("bp_17", "Bụng dưới", true, phanVungCoThes.get(5),genderRepo.findByGioiTinhID(1)),
                    new BoPhanCoThe("bp_18", "Bụng dưới", true, phanVungCoThes.get(5),genderRepo.findByGioiTinhID(2))

            );
            phanVungCoThes.get(5).setBoPhanCoThes(boPhanCoThes6);
            List<BoPhanCoThe> boPhanCoThes7 = List.of(
                    new BoPhanCoThe("bp_19", "Bẹn", true, phanVungCoThes.get(6),genderRepo.findByGioiTinhID(1)),
                    new BoPhanCoThe("bp_20", "Bẹn", true, phanVungCoThes.get(6),genderRepo.findByGioiTinhID(2)),
                    new BoPhanCoThe("bp_21", "Bộ phận sinh dục", true, phanVungCoThes.get(6),genderRepo.findByGioiTinhID(1)),
                    new BoPhanCoThe("bp_22", "Bộ phận sinh dục", true, phanVungCoThes.get(6),genderRepo.findByGioiTinhID(2)),
                    new BoPhanCoThe("bp_23", "Trên xương mu", true, phanVungCoThes.get(6),genderRepo.findByGioiTinhID(1)),
                    new BoPhanCoThe("bp_24", "Trên xương mu", true, phanVungCoThes.get(6),genderRepo.findByGioiTinhID(2))
                    );
            phanVungCoThes.get(6).setBoPhanCoThes(boPhanCoThes7);
            List<BoPhanCoThe> boPhanCoThes8 = List.of(
                    new BoPhanCoThe("bp_25", "Lưng trên", true, phanVungCoThes.get(7),null),
                    new BoPhanCoThe("bp_26", "Lưng dưới", true, phanVungCoThes.get(7),null),
                    new BoPhanCoThe("bp_27", "Mạn sườn phải", true, phanVungCoThes.get(7),null),
                    new BoPhanCoThe("bp_28", "Mạn sườn trái", true, phanVungCoThes.get(7),null),
                    new BoPhanCoThe("bp_29", "Xương cụt", true, phanVungCoThes.get(8),null)
            );
            phanVungCoThes.get(7).setBoPhanCoThes(boPhanCoThes8);

            List<TrieuChung> trieuChungs = List.of(
                    new TrieuChung("Sp_1", "Đau đầu kéo dài", true),
                    new TrieuChung("Sp_2", "Nôn mửa, chóng mặt", true),
                    new TrieuChung("Sp_3", "Co giật", true),
                    new TrieuChung("Sp_4",  "Yếu cơ / mất cảm giác một phần cơ thể, tê bì", true),
                    new TrieuChung("Sp_5", "Tê bì", true),
                    new TrieuChung("Sp_6", "Sụp mí hoặc mất khả năng di chuyển mắt", true),
                    new TrieuChung("Sp_7", "Nhìn đôi (song thị)", true),
                    new TrieuChung("Sp_8", "Giảm hoặc mất thị lực đột ngột", true),
                    new TrieuChung("Sp_9", "Rối loạn khả năng đi lại", true),
                    new TrieuChung("Sp_10", "Rối loạn khả năng tiểu tiện hoặc đại tiện", true),
                    new TrieuChung("Sp_11", "Giảm phản xạ hoặc mất khả năng phối hợp", true),
                    new TrieuChung("Sp_12", "Xuất hiện khối u và hạch", true),
                    new TrieuChung("Sp_13", "Nuốt đau, nuốt vướng hoặc cảm giác nghẹn", true),
                    new TrieuChung("Sp_14", "Khàn giọng hoặc thay đổi giọng nói", true),
                    new TrieuChung("Sp_15", "Nghẹt mũi một bên kéo dài hoặc chảy máu cam", true),
                    new TrieuChung("Sp_16", "Loét miệng, lưỡi hoặc khối trong khoang miệng không", true),
                    new TrieuChung("Sp_17", "Nốt ruồi hoặc đốm da thay đổi bất thường", true),
                    new TrieuChung("Sp_18", "Vết loét không lành sau nhiều tuần", true),
                    new TrieuChung("Sp_19", "Mắt lồi bất thường", true),
                    new TrieuChung("Sp_20", "Đau nhức vùng mắt khi di chuyển mắt", true),
                    new TrieuChung("Sp_21", "Vàng da, vàng mắt, nước tiểu sẫm màu", true),
                    new TrieuChung("Sp_22", "Đau hạ sườn phải / Đau vùng thượng vị", true),
                    new TrieuChung("Sp_23", "Sút cân không rõ nguyên nhân", true),
                    new TrieuChung("Sp_24", "Mệt mỏi, chán ăn, khó tiêu nhẹ", true),
                    new TrieuChung("Sp_25", "Đau bụng chưa rõ vị trí, đau thoáng qua", true),
                    new TrieuChung("Sp_26", "Khó chịu vùng bụng không đặc trưng", true),
                    new TrieuChung("Sp_27", "Đau âm ỉ hoặc đau tăng khi cử động, hít sâu, xoay người.", true),
                    new TrieuChung("Sp_28", "Đau rõ tại một điểm khi ấn", true),
                    new TrieuChung("Sp_29", "Căng cứng cơ lưng sau làm việc văn phòng.", true)
                    );
            phanVungCoTheRepo.saveAll(phanVungCoThes);
            trieuChungRepo.saveAll(trieuChungs);
            log.info("Insert default phanVungCoThes data into the database.");
        }
        if(trieuChungCuaBoPhanRepo.count()==0){
            List<TrieuChung> trieuChungs = trieuChungRepo.findAllAndOrder();
            List<BoPhanCoThe> boPhanCoThes = boPhanCoTheRepo.findAllAndOrder();
            log.info(boPhanCoThes.size()+" "+ boPhanCoThes.get(24).getBoPhanID());

            List<TrieuChungCuaBoPhan> trieuChungCuaBoPhans = List.of(
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(0), boPhanCoThes.get(0)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(1), boPhanCoThes.get(0)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(2), boPhanCoThes.get(0)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(3), boPhanCoThes.get(0)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(4), boPhanCoThes.get(0)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(5), boPhanCoThes.get(3)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(6), boPhanCoThes.get(3)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(7), boPhanCoThes.get(3)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(8), boPhanCoThes.get(9)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(8), boPhanCoThes.get(24)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(9), boPhanCoThes.get(9)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(9), boPhanCoThes.get(24)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(10), boPhanCoThes.get(9)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(10), boPhanCoThes.get(24)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(11), boPhanCoThes.get(0)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(11), boPhanCoThes.get(2)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(11), boPhanCoThes.get(3)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(11), boPhanCoThes.get(9)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(12), boPhanCoThes.get(0)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(12), boPhanCoThes.get(9)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(13), boPhanCoThes.get(0)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(13), boPhanCoThes.get(9)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(14), boPhanCoThes.get(0)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(15), boPhanCoThes.get(0)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(16), boPhanCoThes.get(2)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(17), boPhanCoThes.get(2)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(18), boPhanCoThes.get(3)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(19), boPhanCoThes.get(3)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(20), boPhanCoThes.get(15)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(20), boPhanCoThes.get(25)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(21), boPhanCoThes.get(15)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(21), boPhanCoThes.get(25)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(22), boPhanCoThes.get(15)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(22), boPhanCoThes.get(25)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(23), boPhanCoThes.get(15)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(24), boPhanCoThes.get(15)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(25), boPhanCoThes.get(15)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(26), boPhanCoThes.get(25)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(27), boPhanCoThes.get(25)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(28), boPhanCoThes.get(25)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(0), boPhanCoThes.get(2)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(2), boPhanCoThes.get(2)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(3), boPhanCoThes.get(2)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(3), boPhanCoThes.get(9)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(4), boPhanCoThes.get(9)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(3), boPhanCoThes.get(24)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(26), boPhanCoThes.get(24)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(27), boPhanCoThes.get(24)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(28), boPhanCoThes.get(24))
            );
            trieuChungCuaBoPhanRepo.saveAll(trieuChungCuaBoPhans);

            List<PhongKham> phongKhams = phongKhamRepo.findAllAndOrder();
            List<ChanDoanBangBoPhan> chanDoanBangBoPhans = List.of(
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(1), phongKhams.get(3), false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(1), phongKhams.get(9),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(1), phongKhams.get(10),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(4), phongKhams.get(3),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(4), phongKhams.get(9),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(4), phongKhams.get(10),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(5), phongKhams.get(3),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(5), phongKhams.get(9),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(5), phongKhams.get(10),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(6), phongKhams.get(3),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(6), phongKhams.get(9),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(6), phongKhams.get(10),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(7), phongKhams.get(3),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(7), phongKhams.get(9),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(7), phongKhams.get(10),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(8), phongKhams.get(3),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(8), phongKhams.get(9),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(8), phongKhams.get(10),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(10), phongKhams.get(8),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(10), phongKhams.get(10),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(11), phongKhams.get(8),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(11), phongKhams.get(10),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(12), phongKhams.get(2),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(12), phongKhams.get(10),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(25), phongKhams.get(11),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(27), phongKhams.get(9),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(27), phongKhams.get(11),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(28), phongKhams.get(11),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(13), phongKhams.get(8),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(13), phongKhams.get(9),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(14), phongKhams.get(1),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(16), phongKhams.get(4),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(16), phongKhams.get(6),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(16), phongKhams.get(10),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(17), phongKhams.get(0),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(18), phongKhams.get(10),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(18), phongKhams.get(11),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(19), phongKhams.get(0),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(20), phongKhams.get(4),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(20), phongKhams.get(6),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(20), phongKhams.get(10),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(21), phongKhams.get(0),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(22), phongKhams.get(4),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(22), phongKhams.get(6),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(22), phongKhams.get(10),false),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(23), phongKhams.get(0),false),


                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(0), phongKhams.get(3),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(0), phongKhams.get(9),true),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(2), phongKhams.get(3),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(2), phongKhams.get(9),true),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(3), phongKhams.get(3),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(3), phongKhams.get(9),true),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(9), phongKhams.get(3),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(9), phongKhams.get(9),true),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(15), phongKhams.get(6),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(15), phongKhams.get(10),true),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(24), phongKhams.get(11),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(24), phongKhams.get(9),true),

                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(25), phongKhams.get(11),false),
                    new ChanDoanBangBoPhan(UUID.randomUUID().toString(), boPhanCoThes.get(25), phongKhams.get(10),true)

                    );
            chanDoanBangBoPhanRepo.saveAll(chanDoanBangBoPhans);

            List<ChanDoanBangBoPhanVaTrieuChung> chanDoanBangBoPhanVaTrieuChungs = List.of(
                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_1", "Sp_1"), phongKhams.get(7), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_1", "Sp_2"), phongKhams.get(7), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_1", "Sp_2"), phongKhams.get(7), 5),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_1", "Sp_4"), phongKhams.get(7), 4),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_1", "Sp_5"), phongKhams.get(7), 2),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_1", "Sp_12"), phongKhams.get(3), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_1", "Sp_13"), phongKhams.get(3), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_1", "Sp_14"), phongKhams.get(3), 2),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_1", "Sp_15"), phongKhams.get(3), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_1", "Sp_16"), phongKhams.get(3), 4)
                    );
            chanDoanBangBoPhanVaTrieuChungRepo.saveAll(chanDoanBangBoPhanVaTrieuChungs);
            log.info("Bp_1");
            chanDoanBangBoPhanVaTrieuChungs = List.of(
                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_3", "Sp_17"), phongKhams.get(3), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_3", "Sp_18"), phongKhams.get(3), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_3", "Sp_12"), phongKhams.get(3), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_3", "Sp_1"), phongKhams.get(7), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_3", "Sp_3"), phongKhams.get(7), 5),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_3", "Sp_4"), phongKhams.get(7), 4)
                    );
            chanDoanBangBoPhanVaTrieuChungRepo.saveAll(chanDoanBangBoPhanVaTrieuChungs);
            log.info("Bp_3");
            chanDoanBangBoPhanVaTrieuChungs = List.of(
                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_4", "Sp_19"), phongKhams.get(3), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_4", "Sp_20"), phongKhams.get(3), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_4", "Sp_12"), phongKhams.get(3), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_4", "Sp_6"), phongKhams.get(7), 4),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_4", "Sp_7"), phongKhams.get(7), 4),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_4", "Sp_8"), phongKhams.get(7), 5)
                    );
            chanDoanBangBoPhanVaTrieuChungRepo.saveAll(chanDoanBangBoPhanVaTrieuChungs);
            log.info("Bp_4");
            chanDoanBangBoPhanVaTrieuChungs = List.of(
                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_10", "Sp_12"), phongKhams.get(3), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_10", "Sp_13"), phongKhams.get(3), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_10", "Sp_14"), phongKhams.get(3), 2),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_10", "Sp_4"), phongKhams.get(7), 4),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_10", "Sp_5"), phongKhams.get(7), 2),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_10", "Sp_9"), phongKhams.get(7), 4),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_10", "Sp_10"), phongKhams.get(7), 4),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_10", "Sp_11"), phongKhams.get(7), 4)
            );
            chanDoanBangBoPhanVaTrieuChungRepo.saveAll(chanDoanBangBoPhanVaTrieuChungs);
            log.info("Bp_10");
            chanDoanBangBoPhanVaTrieuChungs = List.of(

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_16", "Sp_21"), phongKhams.get(5), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_16", "Sp_22"), phongKhams.get(5), 2),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_16", "Sp_23"), phongKhams.get(5), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_16", "Sp_24"), phongKhams.get(6), 1),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_16", "Sp_25"), phongKhams.get(6), 1),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_16", "Sp_26"), phongKhams.get(6), 1)
                    );
            chanDoanBangBoPhanVaTrieuChungRepo.saveAll(chanDoanBangBoPhanVaTrieuChungs);
            log.info("Bp_16");
            chanDoanBangBoPhanVaTrieuChungs = List.of(

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_25", "Sp_27"), phongKhams.get(11), 2),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_25", "Sp_28"), phongKhams.get(11), 2),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_25", "Sp_29"), phongKhams.get(11), 1),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_25", "Sp_4"), phongKhams.get(7), 4),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_25", "Sp_9"), phongKhams.get(7), 4),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_25", "Sp_10"), phongKhams.get(7), 4),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_25", "Sp_11"), phongKhams.get(7), 4)
                    );
            chanDoanBangBoPhanVaTrieuChungRepo.saveAll(chanDoanBangBoPhanVaTrieuChungs);
            log.info("Bp_25");
            chanDoanBangBoPhanVaTrieuChungs = List.of(
                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_26", "Sp_21"), phongKhams.get(5), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_26", "Sp_22"), phongKhams.get(5), 2),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_26", "Sp_23"), phongKhams.get(5), 3),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_26", "Sp_27"), phongKhams.get(11), 2),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_26", "Sp_28"), phongKhams.get(11), 2),

                    new ChanDoanBangBoPhanVaTrieuChung(UUID.randomUUID().toString(),trieuChungCuaBoPhanRepo.findByBoPhanIDAndTrieuChungID("Bp_26", "Sp_29"), phongKhams.get(11), 1)
                    );
            chanDoanBangBoPhanVaTrieuChungRepo.saveAll(chanDoanBangBoPhanVaTrieuChungs);
            log.info("Bp_26");
        }
        if(trangThaiKhamSoBoRepo.count()==0){
            List<TrangThaiKham> trangThaiKhams = List.of(
                    new TrangThaiKham("Đang khám"),
                    new TrangThaiKham("Cần tái khám"),
                    new TrangThaiKham("Đã hủy"),
                    new TrangThaiKham("Đã khám")
            );
            trangThaiKhamSoBoRepo.saveAll(trangThaiKhams);
        }
        if(accountRepo.count()==0){
            TaiKhoan taiKhoan = new TaiKhoan();
            taiKhoan.setAccountID(UUID.randomUUID().toString());
            taiKhoan.setRole(roleRepo.findByRoleId(1));
            taiKhoan.setGioiTinh(genderRepo.findByGioiTinhID(1));
            Date date = new Date();
            date.setDate(22);
            date.setMonth(Calendar.DECEMBER);
            date.setYear(2002);
            taiKhoan.setNgaySinh(date);
            taiKhoan.setTen("Nguyễn Quang Hùng");
            taiKhoan.setDanToc(danTocRepository.findByDanTocID(1));
            taiKhoan.setCccdCmt("001202002242");
            taiKhoan.setDiaChi("Ha Noi");
            taiKhoan.setEmail("abcGamil@gmail.com");
            taiKhoan.setSdt("0903332054");
            try{
                taiKhoan.setMatKhau(decodeEncodeUtil.encryptAES("12345Aa!"));
            }catch (Exception e){
                log.error("Exception", e);
            }
            taiKhoan = accountRepo.save(taiKhoan);

            SoKham soKham = new SoKham();
            soKham.setSoKhamID(UUID.randomUUID().toString());
            soKham.setTaiKhoan(taiKhoan);
            soKham.setBhyt("012345678910");
            soKham = soKhamRepo.save(soKham);

            LoiSongNguoiBenh loiSongNguoiBenh = new LoiSongNguoiBenh();
            loiSongNguoiBenh.setLoiSongNguoiBenhID(UUID.randomUUID().toString());
            loiSongNguoiBenh.setSoKham(soKham);
            try {
                loiSongNguoiBenhRepo.save(loiSongNguoiBenh);
            }catch (Exception e){
                log.error("Get data from database fail");
            }

            NguoiGiamHo nguoiGiamHo = new NguoiGiamHo();
            nguoiGiamHo.setGiamHoID(UUID.randomUUID().toString());
            nguoiGiamHo.setTen("Nguyễn Duy Hoàn");
            nguoiGiamHo.setSdt("0902341777");
            nguoiGiamHo.setCccdCmt("123456789098");
            nguoiGiamHo.setMoiQuanHe("Chú");
            nguoiGiamHo.setSoKham(soKham);
            nguoiGiamHoRepo.save(nguoiGiamHo);


            TaiKhoan bacsi = new TaiKhoan();
            bacsi.setAccountID(UUID.randomUUID().toString());
            bacsi.setRole(roleRepo.findByRoleId(2));
            bacsi.setGioiTinh(genderRepo.findByGioiTinhID(1));

            LocalDate localDate = LocalDate.of(1982,12,22);
            Date birth = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            bacsi.setNgaySinh(birth);
            bacsi.setTen("Nguyễn Huy Hùng");
            bacsi.setDanToc(danTocRepository.findByDanTocID(1));
            bacsi.setCccdCmt("001202002256");
            bacsi.setDiaChi("Ha Noi");
            bacsi.setEmail("bacsiGamil@gmail.com");
            bacsi.setSdt("0903332075");
            try{
                bacsi.setMatKhau(decodeEncodeUtil.encryptAES("12345Aa!"));
            }catch (Exception e){
                log.error("Exception", e);
            }
            bacsi = accountRepo.save(bacsi);

            BacSi bacSiAtCoSo = new BacSi();
            bacSiAtCoSo.setBacSiID(UUID.randomUUID().toString());
            bacSiAtCoSo.setTaiKhoan(bacsi);
            bacSiAtCoSo.setCoSoBenhVien(coSoBenhVienRepo.findById(1).get());
            bacSiAtCoSo = bacSiRepo.save(bacSiAtCoSo);

            LichSuKham lichSuKham = new LichSuKham();
            lichSuKham.setBacSi(bacSiAtCoSo);
            lichSuKham.setLichSuKhamID(UUID.randomUUID().toString());
            lichSuKham.setSoKham(soKham);
            LocalDateTime localDateTaiKhamHuyStart1 = LocalDateTime.of(2024,12,22,8,30); // Example LocalDate
            lichSuKham.setNgayKham(localDateTaiKhamHuyStart1);
            LocalDateTime localDateTaiKhamHuyEnd1 = LocalDateTime.of(2024,12,22,8,50); // Example LocalDate
            lichSuKham.setNgayKetLuan(localDateTaiKhamHuyEnd1);
            lichSuKham.setCoSoBenhVien(coSoBenhVienRepo.findById(1).get());
            lichSuKham.setTrangThaiKham(trangThaiKhamSoBoRepo.findById(3).get());
            lichSuKham = lichSuKhamRepo.save(lichSuKham);

            PhongKhamChiTiet phongKhamChiTiet  = phongKhamChiTietRepo.findById("pkct1").get();

            DichVuKham dichVuKhamTestData = phongKhamChiTiet.getPhongKham().getDichVuKham();
            LichSuKhamChiTiet lichSuKhamChiTiet = new LichSuKhamChiTiet();
            lichSuKhamChiTiet.setNgayKham(localDateTaiKhamHuyStart1);
            lichSuKhamChiTiet.setLichSuKham(lichSuKham);
            lichSuKhamChiTiet.setSoKhamThuTu(3);
            lichSuKhamChiTiet.setGia(dichVuKhamTestData.getGia());
            lichSuKhamChiTiet.setTenDichVuKham(dichVuKhamTestData.getTenLoai());
            lichSuKhamChiTiet.setPhongKhamChiTiet(phongKhamChiTiet);
            lichSuKhamChiTiet.setLichSuKhamChiTietID(UUID.randomUUID().toString());
            lichSuKhamChiTietRepo.save(lichSuKhamChiTiet);

            lichSuKham.setTongThu(lichSuKhamChiTiet.getGia());
            lichSuKhamRepo.save(lichSuKham);

            LichSuKham lichSuKhamTaiKham = new LichSuKham();
            lichSuKhamTaiKham.setBacSi(bacSiAtCoSo);
            lichSuKhamTaiKham.setLichSuKhamID(UUID.randomUUID().toString());
            lichSuKhamTaiKham.setSoKham(soKham);

            LocalDateTime localDateTaiKhamStart1 = LocalDateTime.of(2024,12,24,8,30); // Example LocalDate
            lichSuKhamTaiKham.setNgayKham(localDateTaiKhamStart1);

            LocalDateTime localDateTaiKhamEnd1 = LocalDateTime.of(2024,12,24,14,50); // Example LocalDate
            lichSuKhamTaiKham.setNgayKetLuan(localDateTaiKhamEnd1);
            lichSuKhamTaiKham.setKetLuan("Cần tái khám");
            lichSuKhamTaiKham.setGhiChu("Ăn đủ bữa");
            lichSuKhamTaiKham.setCoSoBenhVien(coSoBenhVienRepo.findById(1).get());
            lichSuKhamTaiKham.setTrangThaiKham(trangThaiKhamSoBoRepo.findById(2).get());
            lichSuKhamTaiKham = lichSuKhamRepo.save(lichSuKhamTaiKham);

            List<LichSuKhamChiTiet> lichSuKhamChiTiets = new ArrayList<>();
            PhongKhamChiTiet phongKhamChiTietTaiKhamSoBo  = phongKhamChiTietRepo.findById("pkct1").get();
            DichVuKham dichVuKhamTestDataTaiKham = phongKhamChiTietTaiKhamSoBo.getPhongKham().getDichVuKham();
            LichSuKhamChiTiet lichSuKhamChiTietTaiKham = new LichSuKhamChiTiet();
            lichSuKhamChiTietTaiKham.setLichSuKhamChiTietID(UUID.randomUUID().toString());
            lichSuKhamChiTietTaiKham.setLichSuKham(lichSuKhamTaiKham);
            lichSuKhamChiTietTaiKham.setSoKhamThuTu(3);
            lichSuKhamChiTietTaiKham.setPhongKhamChiTiet(phongKhamChiTietTaiKhamSoBo);
            lichSuKhamChiTietTaiKham.setGia(dichVuKhamTestDataTaiKham.getGia());
            lichSuKhamChiTietTaiKham.setTenDichVuKham(dichVuKhamTestDataTaiKham.getTenLoai());

            LocalDateTime localDateTaiKhamStart2 = LocalDateTime.of(2024,12,24,8,30); // Example LocalDate
            lichSuKhamChiTietTaiKham.setNgayKham(localDateTaiKhamStart2);
            LocalDateTime localDateTaiKhamEnd2 = LocalDateTime.of(2024,12,24,9,0); // Example LocalDate
            lichSuKhamChiTietTaiKham.setNgayKetLuan(localDateTaiKhamEnd2);
            lichSuKhamChiTiets.add(lichSuKhamChiTietTaiKham);

            PhongKhamChiTiet phongKhamChiTietNoiSoi  = phongKhamChiTietRepo.findById("pkct22").get();
            DichVuKham dichVuKhamTestDataTaiKhamNoiSoi = phongKhamChiTietNoiSoi.getPhongKham().getDichVuKham();
            LichSuKhamChiTiet lichSuKhamChiTietTaiKham1 = new LichSuKhamChiTiet();
            lichSuKhamChiTietTaiKham1.setLichSuKhamChiTietID(UUID.randomUUID().toString());
            lichSuKhamChiTietTaiKham1.setLichSuKham(lichSuKhamTaiKham);
            lichSuKhamChiTietTaiKham1.setSoKhamThuTu(4);
            lichSuKhamChiTietTaiKham1.setPhongKhamChiTiet(phongKhamChiTietNoiSoi);
            lichSuKhamChiTietTaiKham1.setGia(dichVuKhamTestDataTaiKhamNoiSoi.getGia());
            lichSuKhamChiTietTaiKham1.setTenDichVuKham(dichVuKhamTestDataTaiKhamNoiSoi.getTenLoai());
            LocalDateTime localDateTaiKhamStart3 = LocalDateTime.of(2024,12,24,10,0); // Example LocalDate
            lichSuKhamChiTietTaiKham1.setNgayKham(localDateTaiKhamStart3);
            LocalDateTime localDateTaiKhamEnd3 = LocalDateTime.of(2024,12,24,11,0); // Example LocalDate
            lichSuKhamChiTietTaiKham1.setNgayKetLuan(localDateTaiKhamEnd3);
            lichSuKhamChiTiets.add(lichSuKhamChiTietTaiKham1);

            PhongKhamChiTiet phongKhamChiTietSieuAm  = phongKhamChiTietRepo.findById("pkct20").get();
            DichVuKham dichVuKhamTestDataSieuAm = phongKhamChiTietSieuAm.getPhongKham().getDichVuKham();
            LichSuKhamChiTiet lichSuKhamChiTietTaiKham2 = new LichSuKhamChiTiet();
            lichSuKhamChiTietTaiKham2.setLichSuKhamChiTietID(UUID.randomUUID().toString());
            lichSuKhamChiTietTaiKham2.setLichSuKham(lichSuKhamTaiKham);
            lichSuKhamChiTietTaiKham2.setSoKhamThuTu(5);
            lichSuKhamChiTietTaiKham2.setPhongKhamChiTiet(phongKhamChiTietSieuAm);
            lichSuKhamChiTietTaiKham2.setGia(dichVuKhamTestDataSieuAm.getGia());
            lichSuKhamChiTietTaiKham2.setTenDichVuKham(dichVuKhamTestDataSieuAm.getTenLoai());
            LocalDateTime localDateTaiKhamStart4 = LocalDateTime.of(2024,12,24,12,0); // Example LocalDate
            lichSuKhamChiTietTaiKham2.setNgayKham(localDateTaiKhamStart4);
            LocalDateTime localDateTaiKhamEnd4 = LocalDateTime.of(2024,12,24,13,0); // Example LocalDate
            lichSuKhamChiTietTaiKham2.setNgayKetLuan(localDateTaiKhamEnd4);
            lichSuKhamChiTiets.add(lichSuKhamChiTietTaiKham2);

            lichSuKhamChiTietRepo.saveAll(lichSuKhamChiTiets);
            lichSuKhamTaiKham.setTongThu(lichSuKhamChiTiets.stream()
                    .map(LichSuKhamChiTiet::getGia) // Extract the numeric values
                    .reduce(0.0, Double::sum));
            lichSuKhamRepo.save(lichSuKhamTaiKham);


            LichSuKham lichSuKhamDaKham = new LichSuKham();
            lichSuKhamDaKham.setBacSi(bacSiAtCoSo);
            lichSuKhamDaKham.setLichSuKhamID(UUID.randomUUID().toString());
            lichSuKhamDaKham.setSoKham(soKham);

            LocalDateTime localDateDaKhamStart1 = LocalDateTime.of(2024,12,26,8,30); // Example LocalDate
            lichSuKhamDaKham.setNgayKham(localDateDaKhamStart1);
            LocalDateTime localDateDaKhamEnd1 = LocalDateTime.of(2024,12,26,14,50); // Example LocalDate
            lichSuKhamDaKham.setNgayKetLuan(localDateDaKhamEnd1);
            lichSuKhamDaKham.setKetLuan("Đã khám");
            lichSuKhamDaKham.setGhiChu("Ngủ đủ giấc");
            lichSuKhamDaKham.setCoSoBenhVien(coSoBenhVienRepo.findById(1).get());
            lichSuKhamDaKham.setTrangThaiKham(trangThaiKhamSoBoRepo.findById(4).get());
            lichSuKhamDaKham = lichSuKhamRepo.save(lichSuKhamDaKham);

            List<LichSuKhamChiTiet> lichSuKhamChiTietsDaXong = new ArrayList<>();
            PhongKhamChiTiet phongKhamChiTietDaKhamSoBo  = phongKhamChiTietRepo.findById("pkct1").get();
            DichVuKham dichVuKhamTestDataDaKham = phongKhamChiTietDaKhamSoBo.getPhongKham().getDichVuKham();
            LichSuKhamChiTiet lichSuKhamChiTietDaKham = new LichSuKhamChiTiet();
            lichSuKhamChiTietDaKham.setLichSuKhamChiTietID(UUID.randomUUID().toString());
            lichSuKhamChiTietDaKham.setLichSuKham(lichSuKhamDaKham);
            lichSuKhamChiTietDaKham.setSoKhamThuTu(5);
            lichSuKhamChiTietDaKham.setPhongKhamChiTiet(phongKhamChiTietDaKhamSoBo);
            lichSuKhamChiTietDaKham.setGia(dichVuKhamTestDataDaKham.getGia());
            lichSuKhamChiTietDaKham.setTenDichVuKham(dichVuKhamTestDataDaKham.getTenLoai());

            LocalDateTime localDateDaKhamStart2 = LocalDateTime.of(2024,12,26,8,30); // Example LocalDate
            lichSuKhamChiTietDaKham.setNgayKham(localDateDaKhamStart2);
            LocalDateTime localDateDaKhamEnd2 = LocalDateTime.of(2024,12,26,9,0); // Example LocalDate
            lichSuKhamChiTietDaKham.setNgayKetLuan(localDateDaKhamEnd2);
            lichSuKhamChiTietsDaXong.add(lichSuKhamChiTietDaKham);

            PhongKhamChiTiet phongKhamChiTietDaKhamNoiSoi  = phongKhamChiTietRepo.findById("pkct22").get();
            DichVuKham dichVuKhamTestDataDaKhamNoiSoi = phongKhamChiTietDaKhamNoiSoi.getPhongKham().getDichVuKham();
            LichSuKhamChiTiet lichSuKhamChiTietDaKham1 = new LichSuKhamChiTiet();
            lichSuKhamChiTietDaKham1.setLichSuKhamChiTietID(UUID.randomUUID().toString());
            lichSuKhamChiTietDaKham1.setLichSuKham(lichSuKhamDaKham);
            lichSuKhamChiTietDaKham1.setSoKhamThuTu(8);
            lichSuKhamChiTietDaKham1.setPhongKhamChiTiet(phongKhamChiTietNoiSoi);
            lichSuKhamChiTietDaKham1.setGia(dichVuKhamTestDataDaKhamNoiSoi.getGia());
            lichSuKhamChiTietDaKham1.setTenDichVuKham(dichVuKhamTestDataDaKhamNoiSoi.getTenLoai());
            LocalDateTime localDateDaKhamStart3 = LocalDateTime.of(2024,12,26,10, 0); // Example LocalDate
            lichSuKhamChiTietDaKham1.setNgayKham(localDateDaKhamStart3);
            LocalDateTime localDateDaKhamEnd3 = LocalDateTime.of(2024,12,26,11,0); // Example LocalDate
            lichSuKhamChiTietDaKham1.setNgayKetLuan(localDateDaKhamEnd3);
            lichSuKhamChiTietsDaXong.add(lichSuKhamChiTietDaKham1);

            PhongKhamChiTiet phongKhamChiTietDaKhamSieuAm  = phongKhamChiTietRepo.findById("pkct20").get();
            DichVuKham dichVuKhamTestDataDaKhamSieuAm = phongKhamChiTietDaKhamSieuAm.getPhongKham().getDichVuKham();
            LichSuKhamChiTiet lichSuKhamChiTietDaKham2 = new LichSuKhamChiTiet();
            lichSuKhamChiTietDaKham2.setLichSuKhamChiTietID(UUID.randomUUID().toString());
            lichSuKhamChiTietDaKham2.setLichSuKham(lichSuKhamDaKham);
            lichSuKhamChiTietDaKham2.setSoKhamThuTu(10);
            lichSuKhamChiTietDaKham2.setPhongKhamChiTiet(phongKhamChiTietSieuAm);
            lichSuKhamChiTietDaKham2.setGia(dichVuKhamTestDataDaKhamSieuAm.getGia());
            lichSuKhamChiTietDaKham2.setTenDichVuKham(dichVuKhamTestDataDaKhamSieuAm.getTenLoai());
            LocalDateTime localDateDaKhamStart4 = LocalDateTime.of(2024,12,26,12, 0); // Example LocalDate
            lichSuKhamChiTietDaKham2.setNgayKham(localDateDaKhamStart4);
            LocalDateTime localDateDaKhamEnd4 = LocalDateTime.of(2024,12,26,13, 0); // Example LocalDate
            lichSuKhamChiTietDaKham2.setNgayKetLuan(localDateDaKhamEnd4);
            lichSuKhamChiTietsDaXong.add(lichSuKhamChiTietDaKham2);
            lichSuKhamChiTietRepo.saveAll(lichSuKhamChiTietsDaXong);

            LichSuSuDungThuoc lichSuSuDungThuoc = new LichSuSuDungThuoc();
            lichSuSuDungThuoc.setTenThuoc("Thuốc A");
            lichSuSuDungThuoc.setHuongDanSuDung("Ngày 2 lần sau ăn trưa tối");
            lichSuSuDungThuoc.setLichSuSuDungThuocID(UUID.randomUUID().toString());
            lichSuSuDungThuoc.setLichSuKham(lichSuKhamDaKham);
            lichSuSuDungThuoc.setDonVi("Viên");
            lichSuSuDungThuoc.setLieuLuong(2.0);
            lichSuSuDungThuocRepo.save(lichSuSuDungThuoc);

            lichSuKhamDaKham.setTongThu(lichSuKhamChiTietsDaXong.stream()
                    .map(LichSuKhamChiTiet::getGia) // Extract the numeric values
                    .reduce(0.0, Double::sum));
            lichSuKhamRepo.save(lichSuKhamDaKham);
        }
//        List<ChanDoan> chanDoans = List.of(
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),phanVungCoThes.get(4), null, null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11),phanVungCoThes.get(4), null, null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),phanVungCoThes.get(9), null, null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11),phanVungCoThes.get(9), null, null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),phanVungCoThes.get(8), null, null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11),phanVungCoThes.get(8), null, null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6),phanVungCoThes.get(1), null, null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),phanVungCoThes.get(1), null, null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(0), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(0), trieuChungs.get(1)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(0), trieuChungs.get(2)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(0), trieuChungs.get(3)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(0), trieuChungs.get(0)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(0), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(0), trieuChungs.get(1)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(0), trieuChungs.get(2)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(0), trieuChungs.get(3)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(0), trieuChungs.get(0)),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(1), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(1), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10),null, boPhanCoThes.get(1), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(2), trieuChungs.get(4)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(2), trieuChungs.get(10)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(2), trieuChungs.get(11)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(2), trieuChungs.get(12)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(2), trieuChungs.get(13)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(4)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(10)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(11)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(12)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(13)),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(2), trieuChungs.get(3)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(2), trieuChungs.get(5)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(3)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(5)),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(3), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(3), trieuChungs.get(4)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(3), trieuChungs.get(5)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(3), trieuChungs.get(6)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(3), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(3), trieuChungs.get(4)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(3), trieuChungs.get(5)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(3), trieuChungs.get(6)),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(4), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(4), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(4), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(4), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(4), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(4), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(5), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(5), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(5), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(6), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(6), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(6), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(7), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(7), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(7), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(8), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(8), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(8), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(9), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(9), trieuChungs.get(3)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(9), trieuChungs.get(7)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(9), trieuChungs.get(8)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(9), trieuChungs.get(9)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(9), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(9), trieuChungs.get(3)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(9), trieuChungs.get(7)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(9), trieuChungs.get(8)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(9), trieuChungs.get(9)),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(8), null, boPhanCoThes.get(10), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(10), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(2), null, boPhanCoThes.get(11), trieuChungs.get(14)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(11), trieuChungs.get(14)),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(8), null, boPhanCoThes.get(11), trieuChungs.get(15)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(11), trieuChungs.get(16)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(8), null, boPhanCoThes.get(11), trieuChungs.get(15)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(11), trieuChungs.get(16)),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(1), null, boPhanCoThes.get(13), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(8), null, boPhanCoThes.get(12), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(12), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(0), null, boPhanCoThes.get(16), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(4), null, boPhanCoThes.get(15), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6), null, boPhanCoThes.get(15), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(15), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(0), null, boPhanCoThes.get(18), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(17), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11), null, boPhanCoThes.get(17), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(0), null, boPhanCoThes.get(20), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(4), null, boPhanCoThes.get(19), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6), null, boPhanCoThes.get(19), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(19), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(0), null, boPhanCoThes.get(22), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(4), null, boPhanCoThes.get(21), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6), null, boPhanCoThes.get(21), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(21), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11), null, boPhanCoThes.get(23), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(23), trieuChungs.get(3)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(23), trieuChungs.get(7)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(23), trieuChungs.get(8)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(23), trieuChungs.get(9)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(23), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(23), trieuChungs.get(3)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(23), trieuChungs.get(7)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(23), trieuChungs.get(8)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(23), trieuChungs.get(9)),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11), null, boPhanCoThes.get(24), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(24), trieuChungs.get(3)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(24), trieuChungs.get(7)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(24), trieuChungs.get(8)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(24), trieuChungs.get(9)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(24), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(24), trieuChungs.get(3)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(24), trieuChungs.get(7)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(24), trieuChungs.get(8)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(24), trieuChungs.get(9)),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11), null, boPhanCoThes.get(25), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(25), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(5), null, boPhanCoThes.get(25), trieuChungs.get(17)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(5), null, boPhanCoThes.get(25), trieuChungs.get(18)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(5), null, boPhanCoThes.get(25), trieuChungs.get(19)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6), null, boPhanCoThes.get(25), trieuChungs.get(17)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6), null, boPhanCoThes.get(25), trieuChungs.get(18)),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6), null, boPhanCoThes.get(25), trieuChungs.get(19)),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11), null, boPhanCoThes.get(26), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(26), null),
//
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11), null, boPhanCoThes.get(27), null),
//                new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(27), null)
//
//        );
//        chanDoanRepo.saveAll(chanDoans);
//        new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(0), boPhanCoThes1.get(0)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(0), boPhanCoThes1.get(2)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(1), boPhanCoThes1.get(0)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(1), boPhanCoThes1.get(2)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(2), boPhanCoThes1.get(0)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(2), boPhanCoThes1.get(2)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(3), boPhanCoThes1.get(0)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(3), boPhanCoThes1.get(2)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(3), boPhanCoThes3.get(1)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(3), boPhanCoThes8.get(0)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(4), boPhanCoThes1.get(3)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(5), boPhanCoThes1.get(3)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(6), boPhanCoThes1.get(3)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(7), boPhanCoThes3.get(1)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(7), boPhanCoThes8.get(0)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(8), boPhanCoThes3.get(1)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(8), boPhanCoThes8.get(0)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(9), boPhanCoThes3.get(1)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(9), boPhanCoThes8.get(0)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(10), boPhanCoThes1.get(1)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(11), boPhanCoThes1.get(1)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(12), boPhanCoThes1.get(1)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(13), boPhanCoThes1.get(1)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(14), boPhanCoThes4.get(1)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(15), boPhanCoThes4.get(1)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(16), boPhanCoThes4.get(1)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(17), boPhanCoThes6.get(0)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(17), boPhanCoThes8.get(2)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(18), boPhanCoThes8.get(2)),
//                new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(19), boPhanCoThes8.get(2))
//        if(phongKhamRepo.count() == 0){
//            List<PhongKham> phongKhams = List.of(
//                    new PhongKham("Văn phòng ngồi nhiều", true)
//            );
//            phongKhamRepo.saveAll(phongKhams);
//            log.info("Insert default moiTruongs data into the database.");
//        }
    }

}
