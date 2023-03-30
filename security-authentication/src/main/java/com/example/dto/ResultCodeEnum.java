package com.example.dto;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),

    NO_MAKE_SUCCESS(200, "全部版权不符合自动制作！"),

    NO_WITHDRAW_SUCCESS(200, "全部版权不满足撤回！"),

    PART_MAKE_SUCCESS(200, "部分版权自动制作成功！"),

    ALL_MAKE_SUCCESS(200, "自动制作成功！"),

    NO_HANDLE(403, "该版权歌词已撤回，请重新上传歌词！"),
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(500, "未知错误"),
    FAIL(500, "失败"),
    TRANS_FAIL(500, "一键翻译失败"),
    /**
     * 参数错误
     */
    PARAM_ERROR(204, "参数错误"),
    PROUDCTID_NULL(204, "产品ID全部为空"),
    /**
     * 内部空指针
     */
    NULL_POINT(500, "内部空指针"),
    /**
     * 内部http请求错误
     */
    ACCEPTED(202, "正在处理,稍后查看"),
    /**
     * 对象id不存在
     */
    NOT_FOUND(404, "资源不存在"),
    NOT_PRODUCT(404, "没有选择产品"),

    NOT_FOUND_OID(404, "未找到oid"),
    NOT_FOUND_ID(404, "未找到此id"),
    /**
     * 没有登录或登录过期
     */
    UNAUTHORIZED(401, "Unauthorized 请求要求用户的身份认证"),
    /**
     * 没有操作权限
     */
    FORBIDDEN(403, "Forbidden 拒绝执行此请求"),
    NOT_HANDLE(403, "当前状态不能处理，请刷新后重试"),
    NOT_REPORT_TYPE(403, "上报类型为空,请重新转码或联系管理员"),
    NOT_PROBLEM_DESCRIPTION(403, "问题描述必填"),

    /**
     * 三大-重点监控
     */
    CP_UPC_EXIST(403, "该推送方的upc监控已存在！"),
    CP_IS_NULL(403, "推送方为空或者不合法！"),
    /**
     * 没有操作权限, 也可以用这个
     */
    METHOD_NOT_ALLOWED(405, "Method Not Allowed 请求方法被禁止"),
    /**
     * 内部请求超时
     */
    REQUEST_TIMEOUT(408, "Request Timeout 内部请求超时"),
    /**
     * 账户已被锁定
     */
    LOCKED(423, "Locked 账户已被锁定"),
    /**
     * 临时重定向
     */
    TEMPORARY_REDIRECT(307, "Temporary Redirect 临时重定向"),

    WALK_WARNING(202, "操作成功,请上传歌词"),

    /**
     * 定帧图制作错误
     */
    PIC_FTP_OUT(500, "定帧图上传失败"),

    /**
     * 字符超长了
     */
     OVER_LENGTH(500, "敏感词标签选择过多，超长了！");
    /**
     * 响应状态码
     */
    private Integer status;
    /**
     * 响应信息
     */
    private String message;

    ResultCodeEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}