package SageOneIntegration.SA.V1_1_2.SageOneApiEntities;

import java.util.Date;

/**
 * Created by Ricardo on 2017-07-13.
 */
public final class SageOneAccountantTask extends SageOneMainEntity {
    private Integer AccountantTaskRecurrenceId;
    private Integer CompanyId;
    private String CompanyName;
    private Integer UserId;
    private String Name;//Required 0-255
    private String Notes;
    private Integer StatusType;
    private Integer ReminderType;
    private Integer ReminderDaysBefore;
    private Boolean AutomaticallyChangeStatusWhenStart;
    private Date NotificationDate;
    private Boolean Notified;
    private Date StartDate;
    private Date EndDate;
    private Integer Duration;

    public final Integer getAccountantTaskRecurrenceId() {
        return (this.isInitialized()) ? this.AccountantTaskRecurrenceId : null;
    }

    public final void setAccountantTaskRecurrenceId(final Integer AccountantTaskRecurrenceId) {
        this.AccountantTaskRecurrenceId = (this.isInitialized()) ? AccountantTaskRecurrenceId : this.AccountantTaskRecurrenceId;
    }

    public final Integer getCompanyId() {
        return (this.isInitialized()) ? this.CompanyId : null;
    }

    public final void setCompanyId(final Integer CompanyId) {
        this.CompanyId = (this.isInitialized()) ? CompanyId : this.CompanyId;
    }

    public final String getCompanyName() {
        return (this.isInitialized()) ? this.CompanyName : null;
    }

    public final void setCompanyName(final String CompanyName) {
        this.CompanyName = (this.isInitialized()) ? CompanyName : this.CompanyName;
    }

    public final Integer getUserId() {
        return (this.isInitialized()) ? this.UserId : null;
    }

    public final void setUserId(final Integer UserId) {
        this.UserId = (this.isInitialized()) ? UserId : this.UserId;
    }

    public final String getName() {
        return (this.isInitialized()) ? this.Name : null;
    }

    public final void setName(final String Name) {
        this.Name = (this.isInitialized()) ? Name : this.Name;
    }

    public final String getNotes() {
        return (this.isInitialized()) ? this.Notes : null;
    }

    public final void setNotes(final String Notes) {
        this.Notes = (this.isInitialized()) ? Notes : this.Notes;
    }

    public final Integer getStatusType() {
        return (this.isInitialized()) ? this.StatusType : null;
    }

    public final void setStatusType(final Integer StatusType) {
        this.StatusType = (this.isInitialized()) ? StatusType : this.StatusType;
    }

/*    public final  get() {
        return (this.isInitialized()) ? this.  : null;
    }

    public final void set(final ) {
        this. = (this.isInitialized()) ?  : this.;
    }

    public final  get() {
        return (this.isInitialized()) ? this.  : null;
    }

    public final void set(final ) {
        this. = (this.isInitialized()) ?  : this.;
    }

    public final  get() {
        return (this.isInitialized()) ? this.  : null;
    }

    public final void set(final ) {
        this. = (this.isInitialized()) ?  : this.;
    }

    public final  get() {
        return (this.isInitialized()) ? this.  : null;
    }

    public final void set(final ) {
        this. = (this.isInitialized()) ?  : this.;
    }

    public final  get() {
        return (this.isInitialized()) ? this.  : null;
    }

    public final void set(final ) {
        this. = (this.isInitialized()) ?  : this.;
    }

    public final  get() {
        return (this.isInitialized()) ? this.  : null;
    }

    public final void set(final ) {
        this. = (this.isInitialized()) ?  : this.;
    }

    public final  get() {
        return (this.isInitialized()) ? this.  : null;
    }

    public final void set(final ) {
        this. = (this.isInitialized()) ?  : this.;
    }

    public final  get() {
        return (this.isInitialized()) ? this.  : null;
    }

    public final void set(final ) {
        this. = (this.isInitialized()) ?  : this.;
    }*/
}
