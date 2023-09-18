package com.repconnect.rc.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TB_INVOICES")
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String code;
    private Date invoiceDate;
    private BigDecimal value;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String observation;
    private Date dueDate;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "invoice_data", referencedColumnName = "uuid")
    private InvoiceData invoiceData;


    public Invoice(UUID uuid, String code, Date invoiceDate, BigDecimal value, String observation, Date dueDate, InvoiceData invoiceData) {
        this.uuid = uuid;
        this.code = code;
        this.invoiceDate = invoiceDate;
        this.value = value;
        this.observation = observation;
        this.dueDate = dueDate;
        this.invoiceData = invoiceData;
    }

    public Invoice() {
    }


    public UUID getUuid() {
        return this.uuid;
    }

    public String getCode() {
        return this.code;
    }

    public Date getInvoiceDate() {
        return this.invoiceDate;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public String getObservation() {
        return this.observation;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public InvoiceData getInvoiceData() {
        return this.invoiceData;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Invoice)) return false;
        final Invoice other = (Invoice) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$uuid = this.getUuid();
        final Object other$uuid = other.getUuid();
        if (!Objects.equals(this$uuid, other$uuid)) return false;
        final Object this$code = this.getCode();
        final Object other$code = other.getCode();
        if (!Objects.equals(this$code, other$code)) return false;
        final Object this$invoiceDate = this.getInvoiceDate();
        final Object other$invoiceDate = other.getInvoiceDate();
        if (!Objects.equals(this$invoiceDate, other$invoiceDate))
            return false;
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        if (!Objects.equals(this$value, other$value)) return false;
        final Object this$observation = this.getObservation();
        final Object other$observation = other.getObservation();
        if (!Objects.equals(this$observation, other$observation))
            return false;
        final Object this$dueDate = this.getDueDate();
        final Object other$dueDate = other.getDueDate();
        if (!Objects.equals(this$dueDate, other$dueDate)) return false;
        final Object this$invoiceData = this.getInvoiceData();
        final Object other$invoiceData = other.getInvoiceData();
        if (!Objects.equals(this$invoiceData, other$invoiceData))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Invoice;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $uuid = this.getUuid();
        result = result * PRIME + ($uuid == null ? 43 : $uuid.hashCode());
        final Object $code = this.getCode();
        result = result * PRIME + ($code == null ? 43 : $code.hashCode());
        final Object $invoiceDate = this.getInvoiceDate();
        result = result * PRIME + ($invoiceDate == null ? 43 : $invoiceDate.hashCode());
        final Object $value = this.getValue();
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        final Object $observation = this.getObservation();
        result = result * PRIME + ($observation == null ? 43 : $observation.hashCode());
        final Object $dueDate = this.getDueDate();
        result = result * PRIME + ($dueDate == null ? 43 : $dueDate.hashCode());
        final Object $invoiceData = this.getInvoiceData();
        result = result * PRIME + ($invoiceData == null ? 43 : $invoiceData.hashCode());
        return result;
    }

    public String toString() {
        return "Invoice(uuid=" + this.getUuid() + ", code=" + this.getCode() + ", invoiceDate=" + this.getInvoiceDate() + ", value=" + this.getValue() + ", observation=" + this.getObservation() + ", dueDate=" + this.getDueDate() + ", invoiceData=" + this.getInvoiceData() + ")";
    }
}
