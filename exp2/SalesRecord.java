public class SalesRecord {
    private String recordId;
    private String salesPerson;
    private String region;
    private double amount;
    private String date;

    public SalesRecord(String recordId, String salesPerson, String region, double amount, String date) {
        this.recordId = recordId;
        this.salesPerson = salesPerson;
        this.region = region;
        this.amount = amount;
        this.date = date;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public String getRegion() {
        return region;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "SalesRecord{" +
                "recordId='" + recordId + '\'' +
                ", salesPerson='" + salesPerson + '\'' +
                ", region='" + region + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}
