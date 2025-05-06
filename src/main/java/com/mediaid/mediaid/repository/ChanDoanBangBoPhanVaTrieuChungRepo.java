package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.ChanDoanBangBoPhanVaTrieuChung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChanDoanBangBoPhanVaTrieuChungRepo extends JpaRepository<ChanDoanBangBoPhanVaTrieuChung, String> {
    @Query(nativeQuery = true, value = "select b.* " +
            "from (select * " +
            "\tfrom mediate_db.trieu_chung_cua_bo_phan a " +
            "\twhere a.bo_phan_co_theid = :boPhanID AND a.trieu_chungid in (:trieuChungids)) a " +
            "inner join mediate_db.chan_doan_bang_bo_phan_va_trieu_chung b on a.trieu_chung_bo_phanid = b.tccuabpid;")
    List<ChanDoanBangBoPhanVaTrieuChung> findByBoPhanIDAndTrieuChungIDList(String boPhanID, List<String> trieuChungids);
}
