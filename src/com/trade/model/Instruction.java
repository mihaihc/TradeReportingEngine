package com.trade.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Instruction {
    private String entityName = null;
    private String operationFlag = null;
    private double agreedFx = 0;
    private String currency = null;
    private Date instructionDate = null;
    private Date settlementDate = null;
    private int units = 0;
    private double pricePerUnit = 0;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getOperationFlag() {
        return operationFlag;
    }

    public void setOperationFlag(String operationFlag) {
        this.operationFlag = operationFlag;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "entityName='" + entityName + '\'' +
                ", operationFlag='" + operationFlag + '\'' +
                ", agreedFx=" + agreedFx +
                ", currency='" + currency + '\'' +
                ", instructionDate=" + instructionDate +
                ", settlementDate=" + settlementDate +
                ", units=" + units +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }

    public double getAgreedFx() {
        return agreedFx;
    }

    public void setAgreedFx(double agreedFx) {
        this.agreedFx = agreedFx;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getInstructionDate() {
        return instructionDate;
    }

    public void setInstructionDate(String instructionDate) {
        DateFormat format = new SimpleDateFormat("dd MMM yyyy");
        try {
            this.instructionDate = format.parse(instructionDate);
        } catch (Exception e) {
            e.printStackTrace();
            this.instructionDate = null;
        }
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        DateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        try {
            this.settlementDate = format.parse(settlementDate);
        } catch (Exception e) {
            this.settlementDate = null;
        }
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
