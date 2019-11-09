package com.bm.oms.dto.base;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
* @author: yingxu.pi@transsnet.com
* @date: 2019/3/27 15:48
*/
@ApiModel("返回对象")
public class RespResult<T> extends BaseEntity {

    @ApiModelProperty("返回码")
    private String code;

    @ApiModelProperty("返回码说明")
    private String msg;

    @ApiModelProperty("总条数")
    private Integer count;

    @ApiModelProperty("业务对象")
    private T data;

    public RespResult() {
    }

    public RespResult(RespCode resp) {
        this.code = resp.getCode();
        this.msg = resp.getMsg();
    }

    public RespResult(String respCode, String respMsg) {
        this.code = respCode;
        this.msg = respMsg;
    }

    public RespResult(String respCode, String respMsg, T data) {
        this.code = respCode;
        this.msg = respMsg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
