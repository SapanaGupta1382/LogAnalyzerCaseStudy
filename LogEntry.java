package com.mycasestudy.Beans;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

public class LogEntry {
        @CsvBindByName(column = "insertId")
        private String insertId;

        @CsvBindByName(column = "jsonPayload.disposition")
        private String disposition;

        @CsvBindByName(column = "jsonPayload.connection.src_ip")
        private String sourceIp;

        @CsvBindByName(column = "jsonPayload.connection.dest_ip")
        private String destIp;

        @CsvBindByName(column = "jsonPayload.connection.dest_port")
        private String destPort;

        @CsvBindByName(column = "jsonPayload.remote_location.region")
        private String region;

        @CsvBindByName(column = "jsonPayload.remote_location.city")
        private String city;

        @CsvBindByName(column = "jsonPayload.remote_location.country")
        private String country;

        @CsvBindByName(column = "jsonPayload.remote_location.continent")
        private String continent;

        @CsvBindByName(column = "jsonPayload.instance.vm_name")
        private String vmName;

        @CsvBindByName(column = "receiveTimestamp")
        private String receiveTimestamp;

        public void setInsertId(String insertId) {
            this.insertId = insertId;
        }

        public void setDisposition(String disposition) {
            this.disposition = disposition;
        }

        public void setSourceIp(String sourceIp) {
            this.sourceIp = sourceIp;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setDestIp(String destIp) {
            this.destIp = destIp;
        }

        public void setDestPort(String destPort) {
            this.destPort = destPort;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setContinent(String continent) {
            this.continent = continent;
        }

        public void setVmName(String vmName) {
            this.vmName = vmName;
        }

        public void setReceiveTimestamp(String receiveTimestamp) {
            this.receiveTimestamp = receiveTimestamp;
        }

        public String getInsertId() {
            return insertId;
        }

        public String getDisposition() {
            return disposition;
        }

        public String getSourceIp() {
            return sourceIp;
        }

        public String getDestIp() {
            return destIp;
        }

        public String getDestPort() {
            return destPort;
        }

        public String getRegion() {
            return region;
        }

        public String getCity() {
            return city;
        }

        public String getCountry() {
            return country;
        }

        public String getContinent() {
            return continent;
        }

        public String getVmName() {
            return vmName;
        }

        public String getReceiveTimestamp() {
            return receiveTimestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LogEntry logEntry = (LogEntry) o;
            return insertId.equals(logEntry.insertId) &&
                    disposition.equals(logEntry.disposition) &&
                    sourceIp.equals(logEntry.sourceIp) &&
                    destIp.equals(logEntry.destIp) &&
                    destPort.equals(logEntry.destPort) &&
                    region.equals(logEntry.region) &&
                    city.equals(logEntry.city) &&
                    country.equals(logEntry.country) &&
                    continent.equals(logEntry.continent) &&
                    vmName.equals(logEntry.vmName) &&
                    receiveTimestamp.equals(logEntry.receiveTimestamp);
        }

        @Override
        public int hashCode() {
            return Objects.hash(insertId, disposition, sourceIp, destIp, destPort, region, city, country, continent, vmName, receiveTimestamp);
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                    "insertId='" + insertId + '\'' +
                    ", disposition='" + disposition + '\'' +
                    ", sourceIp='" + sourceIp + '\'' +
                    ", destIp='" + destIp + '\'' +
                    ", destPort='" + destPort + '\'' +
                    ", region='" + region + '\'' +
                    ", city='" + city + '\'' +
                    ", country='" + country + '\'' +
                    ", continent='" + continent + '\'' +
                    ", vmName='" + vmName + '\'' +
                    ", receiveTimestamp='" + receiveTimestamp + '\'' +
                    '}';
        }
    }
