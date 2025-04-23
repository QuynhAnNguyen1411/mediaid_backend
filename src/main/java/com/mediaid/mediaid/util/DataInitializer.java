package com.mediaid.mediaid.util;

import com.mediaid.mediaid.model.*;
import com.mediaid.mediaid.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    private final ChanDoanRepo chanDoanRepo;

    public DataInitializer(DanTocRepo danTocRepository, GenderRepo genderRepo, RoleRepo roleRepo, LyDoPhauThuatRepo lyDoPhauThuatRepo, MucDoRepo mucDoRepo, PhuongPhapDieuTriRepo phuongPhapDieuTriRepo, LoaiSanPhamRepo loaiSanPhamRepo,TinhTrangSuDungRepo tinhTrangSuDungRepo,
                           ThoiQuenRepo thoiQuenRepo, MoiTruongRepo moiTruongRepo, PhanVungCoTheRepo phanVungCoTheRepo, CoSoBenhVienRepo coSoBenhVienRepo, PhongKhamRepo phongKhamRepo, TrieuChungCuaBoPhanRepo trieuChungCuaBoPhanRepo,
                           TrieuChungRepo trieuChungRepo, BoPhanCoTheRepo boPhanCoTheRepo, ChanDoanRepo chanDoanRepo) {
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
        this.phanVungCoTheRepo = phanVungCoTheRepo;
        this.coSoBenhVienRepo = coSoBenhVienRepo;
        this.phongKhamRepo = phongKhamRepo;
        this.trieuChungCuaBoPhanRepo = trieuChungCuaBoPhanRepo;
        this.trieuChungRepo = trieuChungRepo;
        this.boPhanCoTheRepo = boPhanCoTheRepo;
        this.chanDoanRepo = chanDoanRepo;
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
        if(coSoBenhVienRepo.count() == 0){
            List<CoSoBenhVien> coSoBenhViens = new ArrayList<>();

            CoSoBenhVien coSoBenhVien1 = new CoSoBenhVien(1, "Văn phòng ngồi nhiều", "Văn phòng ngồi nhiều");
            coSoBenhVien1 = coSoBenhVienRepo.save(coSoBenhVien1);
            List<PhongKham> phongKhams = List.of(
                    new PhongKham("pk_1", "Ngoại Phụ khoa", true, true),
                    new PhongKham("pk_2", "Ngoại Vú", true, true),
                    new PhongKham("pk_3", "Tim mạch", true, true),
                    new PhongKham("pk_4", "Đầu mặt cổ", true, true),
                    new PhongKham("pk_5", "Tiết niệu", true, true),
                    new PhongKham("pk_6", "Gan mật", true, true),
                    new PhongKham("pk_7", "Nội", true, true),
                    new PhongKham("pk_8", "Ngoại thần kinh", true, true),
                    new PhongKham("pk_9", "Lồng ngực", true, true),
                    new PhongKham("pk_10", "Chuyên khoa", true, true),
                    new PhongKham("pk_11", "Tổng hợp", true, true),
                    new PhongKham("pk_12", "Cơ xương khớp", true, true)
            );

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

            coSoBenhVien1.setPhongKhamChiTiets(phongKhamChiTietsAddALl);
            phongKhamRepo.saveAll(phongKhams);
            coSoBenhVienRepo.save(coSoBenhVien1);
            log.info("Insert default coSoBenhViens data into the database.");
        }
        if (phanVungCoTheRepo.count() == 0){
            List<PhanVungCoThe> phanVungCoThes = List.of(
                    new PhanVungCoThe("pv_1", "Đầu", true, null),
                    new PhanVungCoThe("pv_2", "Da", true, phongKhamRepo.findById("pk_4").get()),
                    new PhanVungCoThe("pv_3", "Cổ", true, null),
                    new PhanVungCoThe("pv_4", "Ngực", true, null),
                    new PhanVungCoThe("pv_5", "Tay", true, phongKhamRepo.findById("pk_10").get()),
                    new PhanVungCoThe("pv_6", "Bụng", true, null),
                    new PhanVungCoThe("pv_7", "Xương chậu", true, null),
                    new PhanVungCoThe("pv_8", "Lưng", true, null),
                    new PhanVungCoThe("pv_9", "Mông", true, phongKhamRepo.findById("pk_12").get()),
                    new PhanVungCoThe("pv_10", "Chân", true, phongKhamRepo.findById("pk_12").get())
            );
            phanVungCoThes = phanVungCoTheRepo.saveAll(phanVungCoThes);

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
                    new BoPhanCoThe("bp_13", "Vú", true, phanVungCoThes.get(3),genderRepo.findByGioiTinhID(1)),
                    new BoPhanCoThe("bp_14", "Vú", true, phanVungCoThes.get(3),genderRepo.findByGioiTinhID(2))
                    );
            phanVungCoThes.get(3).setBoPhanCoThes(boPhanCoThes4);
            List<BoPhanCoThe> boPhanCoThes6 = List.of(
                    new BoPhanCoThe("bp_15", "Thượng vị (Trên trung tâm bụng) + Bụng trên", true, phanVungCoThes.get(5),null),
                    new BoPhanCoThe("bp_16", "Bụng dưới", true, phanVungCoThes.get(5),genderRepo.findByGioiTinhID(1)),
                    new BoPhanCoThe("bp_17", "Bụng dưới", true, phanVungCoThes.get(5),genderRepo.findByGioiTinhID(2))

            );
            phanVungCoThes.get(5).setBoPhanCoThes(boPhanCoThes6);
            List<BoPhanCoThe> boPhanCoThes7 = List.of(
                    new BoPhanCoThe("bp_18", "Bẹn", true, phanVungCoThes.get(6),genderRepo.findByGioiTinhID(1)),
                    new BoPhanCoThe("bp_19", "Bẹn", true, phanVungCoThes.get(6),genderRepo.findByGioiTinhID(2)),
                    new BoPhanCoThe("bp_20", "Bộ phận sinh dục", true, phanVungCoThes.get(6),genderRepo.findByGioiTinhID(1)),
                    new BoPhanCoThe("bp_21", "Bộ phận sinh dục", true, phanVungCoThes.get(6),genderRepo.findByGioiTinhID(2)),
                    new BoPhanCoThe("bp_22", "Trên xương mu", true, phanVungCoThes.get(6),genderRepo.findByGioiTinhID(1)),
                    new BoPhanCoThe("bp_23", "Trên xương mu", true, phanVungCoThes.get(6),genderRepo.findByGioiTinhID(2))
                    );
            phanVungCoThes.get(6).setBoPhanCoThes(boPhanCoThes7);
            List<BoPhanCoThe> boPhanCoThes8 = List.of(
                    new BoPhanCoThe("bp_24", "Lưng trên", true, phanVungCoThes.get(7),null),
                    new BoPhanCoThe("bp_25", "Lưng dưới", true, phanVungCoThes.get(7),null),
                    new BoPhanCoThe("bp_26", "Mạn sườn phải", true, phanVungCoThes.get(7),null),
                    new BoPhanCoThe("bp_27", "Mạn sườn trái", true, phanVungCoThes.get(7),null),
                    new BoPhanCoThe("bp_28", "Xương cụt", true, phanVungCoThes.get(8),null)
            );
            phanVungCoThes.get(7).setBoPhanCoThes(boPhanCoThes8);

            List<TrieuChung> trieuChungs = List.of(
                    new TrieuChung("Sp_1", "Đau đầu kéo dài", true),
                    new TrieuChung("Sp_2", "Nôn mửa", true),
                    new TrieuChung("Sp_3", "Co giật", true),
                    new TrieuChung("Sp_4",  "Yếu cơ / mất cảm giác một phần cơ thể, tê bì", true),
                    new TrieuChung("Sp_5", "Mắt lồi", true),
                    new TrieuChung("Sp_6", "Đau mắt / giảm thị lực / khó di chuyển mắt", true),
                    new TrieuChung("Sp_7", "Nổi u hoặc cục trong hốc mắt", true),
                    new TrieuChung("Sp_8", "Rối loạn khả năng đi lại", true),
                    new TrieuChung("Sp_9", "Rối loạn khả năng tiểu tiện hoặc đại tiện", true),
                    new TrieuChung("Sp_10", "Giảm phản xạ hoặc mất khả năng phối hợp", true),
                    new TrieuChung("Sp_11", "Nốt ruồi thay đổi bất thường", true),
                    new TrieuChung("Sp_12", "Mảng da dày, sần sùi, đóng vảy nhưng không lành / đổi màu bất thường", true),
                    new TrieuChung("Sp_13", "Vết loét lâu lành", true),
                    new TrieuChung("Sp_14", "Khối u nổi dưới da", true),
                    new TrieuChung("Sp_15", "Tức ngực khi gắng sức / Khó thở khi nằm / Đau thắt ngực", true),
                    new TrieuChung("Sp_16", "Ho kéo dài / ho ra máu", true),
                    new TrieuChung("Sp_17", "Khối bất thường ở vùng ngực / xương ức", true),
                    new TrieuChung("Sp_18", "Vàng da, vàng mắt, nước tiểu sẫm màu", true),
                    new TrieuChung("Sp_19", "Đau âm ỉ vùng mạn sườn phải, lan ra sau lưng hoặc vai / Đau quặn từng cơn", true),
                    new TrieuChung("Sp_20", "Sút cân không rõ nguyên nhân", true)
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
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(0), boPhanCoThes.get(2)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(1), boPhanCoThes.get(0)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(1), boPhanCoThes.get(2)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(2), boPhanCoThes.get(0)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(2), boPhanCoThes.get(2)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(3), boPhanCoThes.get(0)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(3), boPhanCoThes.get(2)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(3), boPhanCoThes.get(9)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(3), boPhanCoThes.get(23)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(3), boPhanCoThes.get(24)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(4), boPhanCoThes.get(3)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(5), boPhanCoThes.get(3)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(6), boPhanCoThes.get(3)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(7), boPhanCoThes.get(9)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(7), boPhanCoThes.get(23)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(7), boPhanCoThes.get(24)),


                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(8), boPhanCoThes.get(9)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(8), boPhanCoThes.get(23)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(8), boPhanCoThes.get(24)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(9), boPhanCoThes.get(9)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(9), boPhanCoThes.get(23)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(9), boPhanCoThes.get(24)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(10), boPhanCoThes.get(1)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(11), boPhanCoThes.get(1)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(12), boPhanCoThes.get(1)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(13), boPhanCoThes.get(1)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(14), boPhanCoThes.get(11)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(15), boPhanCoThes.get(11)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(16), boPhanCoThes.get(11)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(17), boPhanCoThes.get(14)),
                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(17), boPhanCoThes.get(25)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(18), boPhanCoThes.get(25)),

                    new TrieuChungCuaBoPhan(UUID.randomUUID().toString(),trieuChungs.get(19), boPhanCoThes.get(25))
            );
            trieuChungCuaBoPhanRepo.saveAll(trieuChungCuaBoPhans);
            List<PhanVungCoThe> phanVungCoThes = phanVungCoTheRepo.findAllAndOrder();
            List<PhongKham> phongKhams = phongKhamRepo.findAllAndOrder();
            List<ChanDoan> chanDoans = List.of(
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),phanVungCoThes.get(4), null, null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11),phanVungCoThes.get(4), null, null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),phanVungCoThes.get(9), null, null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11),phanVungCoThes.get(9), null, null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),phanVungCoThes.get(8), null, null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11),phanVungCoThes.get(8), null, null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6),phanVungCoThes.get(1), null, null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),phanVungCoThes.get(1), null, null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(0), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(0), trieuChungs.get(1)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(0), trieuChungs.get(2)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(0), trieuChungs.get(3)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(0), trieuChungs.get(0)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(0), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(0), trieuChungs.get(1)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(0), trieuChungs.get(2)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(0), trieuChungs.get(3)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(0), trieuChungs.get(0)),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(1), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(1), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10),null, boPhanCoThes.get(1), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(2), trieuChungs.get(4)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(2), trieuChungs.get(10)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(2), trieuChungs.get(11)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(2), trieuChungs.get(12)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(2), trieuChungs.get(13)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(4)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(10)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(11)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(12)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(13)),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(2), trieuChungs.get(3)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(2), trieuChungs.get(5)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(3)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(2), trieuChungs.get(5)),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3),null, boPhanCoThes.get(3), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(3), trieuChungs.get(4)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(3), trieuChungs.get(5)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7),null, boPhanCoThes.get(3), trieuChungs.get(6)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(3), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(3), trieuChungs.get(4)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(3), trieuChungs.get(5)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9),null, boPhanCoThes.get(3), trieuChungs.get(6)),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(4), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(4), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(4), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(4), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(4), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(4), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(5), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(5), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(5), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(6), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(6), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(6), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(7), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(7), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(7), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(8), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(8), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(8), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(3), null, boPhanCoThes.get(9), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(9), trieuChungs.get(3)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(9), trieuChungs.get(7)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(9), trieuChungs.get(8)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(9), trieuChungs.get(9)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(9), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(9), trieuChungs.get(3)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(9), trieuChungs.get(7)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(9), trieuChungs.get(8)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(9), trieuChungs.get(9)),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(8), null, boPhanCoThes.get(10), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(10), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(2), null, boPhanCoThes.get(11), trieuChungs.get(14)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(11), trieuChungs.get(14)),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(8), null, boPhanCoThes.get(11), trieuChungs.get(15)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(11), trieuChungs.get(16)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(8), null, boPhanCoThes.get(11), trieuChungs.get(15)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(11), trieuChungs.get(16)),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(1), null, boPhanCoThes.get(13), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(8), null, boPhanCoThes.get(12), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(12), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(0), null, boPhanCoThes.get(16), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(4), null, boPhanCoThes.get(15), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6), null, boPhanCoThes.get(15), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(15), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(0), null, boPhanCoThes.get(18), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(17), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11), null, boPhanCoThes.get(17), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(0), null, boPhanCoThes.get(20), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(4), null, boPhanCoThes.get(19), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6), null, boPhanCoThes.get(19), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(19), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(0), null, boPhanCoThes.get(22), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(4), null, boPhanCoThes.get(21), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6), null, boPhanCoThes.get(21), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(10), null, boPhanCoThes.get(21), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11), null, boPhanCoThes.get(23), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(23), trieuChungs.get(3)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(23), trieuChungs.get(7)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(23), trieuChungs.get(8)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(23), trieuChungs.get(9)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(23), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(23), trieuChungs.get(3)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(23), trieuChungs.get(7)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(23), trieuChungs.get(8)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(23), trieuChungs.get(9)),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11), null, boPhanCoThes.get(24), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(24), trieuChungs.get(3)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(24), trieuChungs.get(7)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(24), trieuChungs.get(8)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(7), null, boPhanCoThes.get(24), trieuChungs.get(9)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(24), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(24), trieuChungs.get(3)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(24), trieuChungs.get(7)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(24), trieuChungs.get(8)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(24), trieuChungs.get(9)),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11), null, boPhanCoThes.get(25), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(25), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(5), null, boPhanCoThes.get(25), trieuChungs.get(17)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(5), null, boPhanCoThes.get(25), trieuChungs.get(18)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(5), null, boPhanCoThes.get(25), trieuChungs.get(19)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6), null, boPhanCoThes.get(25), trieuChungs.get(17)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6), null, boPhanCoThes.get(25), trieuChungs.get(18)),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(6), null, boPhanCoThes.get(25), trieuChungs.get(19)),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11), null, boPhanCoThes.get(26), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(26), null),

                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(11), null, boPhanCoThes.get(27), null),
                    new ChanDoan(UUID.randomUUID().toString(), phongKhams.get(9), null, boPhanCoThes.get(27), null)

                    );
            chanDoanRepo.saveAll(chanDoans);
        }
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
