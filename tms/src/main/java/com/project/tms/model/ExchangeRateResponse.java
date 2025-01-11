package com.project.tms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExchangeRateResponse {

    private List<ExchangeRateData> data;
    private Meta meta;

    public List<ExchangeRateData> getData() {
        return data;
    }

    public void setData(List<ExchangeRateData> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public static class ExchangeRateData{

        @JsonProperty("currency_code")
        private String currencyCode;
        private int unit;
        private Rate rate;

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public int getUnit() {
            return unit;
        }

        public void setUnit(int unit) {
            this.unit = unit;
        }

        public Rate getRate() {
            return rate;
        }

        public void setRate(Rate rate) {
            this.rate = rate;
        }
    }

    public static class Rate{

        private String date;
        @JsonProperty("buying_rate")
        private Double buyingRate;
        @JsonProperty("selling_rate")
        private Double sellingRate;
        @JsonProperty("middle_rate")
        private Double middleRate;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Double getBuyingRate() {
            return buyingRate;
        }

        public void setBuyingRate(Double buyingRate) {
            this.buyingRate = buyingRate;
        }

        public Double getSellingRate() {
            return sellingRate;
        }

        public void setSellingRate(Double sellingRate) {
            this.sellingRate = sellingRate;
        }

        public Double getMiddleRate() {
            return middleRate;
        }

        public void setMiddleRate(Double middleRate) {
            this.middleRate = middleRate;
        }
    }

    public static class Meta{

        private String quote;
        private String session;
        @JsonProperty("last_updated")
        private String lastUpdated;
        @JsonProperty("total_result")
        private String totalResult;

        public String getQuote() {
            return quote;
        }

        public void setQuote(String quote) {
            this.quote = quote;
        }

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public String getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public String getTotalResult() {
            return totalResult;
        }

        public void setTotalResult(String totalResult) {
            this.totalResult = totalResult;
        }
    }



}
