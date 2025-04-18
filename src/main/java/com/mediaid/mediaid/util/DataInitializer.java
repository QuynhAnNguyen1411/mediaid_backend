package com.mediaid.mediaid.util;

import com.mediaid.mediaid.model.*;
import com.mediaid.mediaid.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

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
    private final PhongKhamRepo phongKhamRepo;


    public DataInitializer(DanTocRepo danTocRepository, GenderRepo genderRepo, RoleRepo roleRepo, LyDoPhauThuatRepo lyDoPhauThuatRepo, MucDoRepo mucDoRepo, PhuongPhapDieuTriRepo phuongPhapDieuTriRepo, LoaiSanPhamRepo loaiSanPhamRepo,TinhTrangSuDungRepo tinhTrangSuDungRepo,
                           ThoiQuenRepo thoiQuenRepo, MoiTruongRepo moiTruongRepo, PhongKhamRepo phongKhamRepo) {
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
        this.phongKhamRepo = phongKhamRepo;
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
//        if(phongKhamRepo.count() == 0){
//            List<PhongKham> phongKhams = List.of(
//                    new PhongKham("Văn phòng ngồi nhiều", true)
//            );
//            phongKhamRepo.saveAll(phongKhams);
//            log.info("Insert default moiTruongs data into the database.");
//        }
    }

}
