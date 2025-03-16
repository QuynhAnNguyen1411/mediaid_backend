package com.mediaid.mediaid.util;

import com.mediaid.mediaid.model.DanToc;
import com.mediaid.mediaid.model.GioiTinh;
import com.mediaid.mediaid.model.Role;
import com.mediaid.mediaid.repository.DanTocRepo;
import com.mediaid.mediaid.repository.GenderRepo;
import com.mediaid.mediaid.repository.RoleRepo;
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

    public DataInitializer(DanTocRepo danTocRepository, GenderRepo genderRepo, RoleRepo roleRepo) {
        this.danTocRepository = danTocRepository;
        this.genderRepo = genderRepo;
        this.roleRepo = roleRepo;
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
                    new Role("Bệnh nhân")
            );
            roleRepo.saveAll(roleList);
            log.info("Insert default Role data into the database.");
        }
    }
}
