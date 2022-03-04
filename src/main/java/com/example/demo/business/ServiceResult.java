package com.example.demo.business;

public class ServiceResult<E> {
    private ResultTypeEnum resultType;
    private E data;
    private Exception error;

    public ServiceResult() {
    }

    public ResultTypeEnum getResultType() {
        return this.resultType;
    }

    public void setResultType(ResultTypeEnum resultType) {
        this.resultType = resultType;
    }

    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Exception getError() {
        return this.error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

    public void setSuccess(E data) {
        this.resultType = ResultTypeEnum.Success;
        this.data = data;
        this.error = null;
    }

    public void setFail(E data, Exception error) {
        this.resultType = ResultTypeEnum.Fail;
        this.data = data;
        this.error = error;
    }
}
