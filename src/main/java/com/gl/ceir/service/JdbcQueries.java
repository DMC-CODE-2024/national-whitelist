package com.gl.ceir.service;

import com.gl.ceir.model.app.ActiveUniqueImei;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class JdbcQueries {
    private final JdbcTemplate jdbcTemplate;

    public JdbcQueries(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Page<ActiveUniqueImei> findAllLatestUniqueImeiInLastXDays(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        String sql = "SELECT a.*,\n       (CASE WHEN m.device_id IS NULL THEN 0 ELSE 1 END) AS validity_flag,\n       m.device_type,\n       m.is_type_approved\nFROM active_unique_imei a\nLEFT JOIN mobile_device_repository m ON a.tac = m.device_id\nWHERE a.created_on <= ? AND a.created_on >= ?\nLIMIT ? OFFSET ?\n";
        String countSql = "SELECT COUNT(*)\nFROM active_unique_imei a\nLEFT JOIN mobile_device_repository m ON a.tac = m.device_id\nWHERE a.created_on <= ? AND a.created_on >= ?\n";
        int total = ((Integer)this.jdbcTemplate.queryForObject(countSql, Integer.class, new Object[] { endDate, startDate })).intValue();
        List<ActiveUniqueImei> results = this.jdbcTemplate.query(sql, new Object[] { endDate, startDate,

                Integer.valueOf(pageable.getPageSize()),
                Long.valueOf(pageable.getOffset()) }, (rs, rowNum) -> mapRowToActiveUniqueImei(rs));
        return (Page<ActiveUniqueImei>)new PageImpl(results, pageable, total);
    }

    private ActiveUniqueImei mapRowToActiveUniqueImei(ResultSet rs) throws SQLException {
        ActiveUniqueImei imei = new ActiveUniqueImei();
        imei.setId(Integer.valueOf(rs.getInt("id")));
        imei.setCreatedOn(rs.getTimestamp("created_on").toLocalDateTime());
        imei.setModifiedOn(getLocalDateTimeOrNull(rs, "modified_on"));
        imei.setTac(rs.getString("tac"));
        imei.setMsisdn(rs.getString("msisdn"));
        imei.setFailedRuleId(Integer.valueOf(rs.getInt("failed_rule_id")));
        imei.setFailedRuleName(rs.getString("failed_rule_name"));
        imei.setImsi(rs.getString("imsi"));
        imei.setMobileOperator(rs.getString("mobile_operator"));
        imei.setCreateFilename(rs.getString("create_filename"));
        imei.setUpdateFilename(rs.getString("update_filename"));
        imei.setUpdatedOn(getLocalDateTimeOrNull(rs, "updated_on"));
        imei.setSystemType(rs.getString("system_type"));
        imei.setAction(rs.getString("action"));
        imei.setPeriod(rs.getString("period"));
        imei.setFeatureName(rs.getString("feature_name"));
        imei.setRecordTime(getLocalDateTimeOrNull(rs, "record_time"));
        imei.setActualImei(rs.getString("actual_imei"));
        imei.setRecordType(rs.getString("record_type"));
        imei.setImei(rs.getString("imei"));
        imei.setRawCdrFileName(rs.getString("raw_cdr_file_name"));
        imei.setImeiArrivalTime(getLocalDateTimeOrNull(rs, "imei_arrival_time"));
        imei.setSource(rs.getString("source"));
        imei.setUpdateRawCdrFileName(rs.getString("update_raw_cdr_file_name"));
        imei.setUpdateImeiArrivalTime(getLocalDateTimeOrNull(rs, "update_imei_arrival_time"));
        imei.setUpdateSource(rs.getString("update_source"));
        imei.setServerOrigin(rs.getString("server_origin"));
        imei.setIsTypeApproved(Integer.valueOf(rs.getInt("is_type_approved")));
        imei.setActualOperator(rs.getString("actual_operator"));
        imei.setIsTestImei(Integer.valueOf(rs.getInt("is_test_imei")));
        imei.setDeviceType(rs.getString("device_type"));
        imei.setIsUsed(Integer.valueOf(rs.getInt("is_used")));
        imei.setValidityFlag(Boolean.valueOf((rs.getInt("validity_flag") == 1)));
        return imei;
    }

    private LocalDateTime getLocalDateTimeOrNull(ResultSet rs, String columnName) throws SQLException {
        Timestamp timestamp = rs.getTimestamp(columnName);
        return (timestamp != null) ? timestamp.toLocalDateTime() : null;
    }
}

