package SageOneIntegration.SageOneApiEntities;

/**
 * Created by ricardo on 2017/06/07.
 */
public class SageOneAdditionalItemPrice extends SageOneMainEntity {
    private Integer ItemId;
    private Double PriceInclusive;
    private Double PriceExclusive;
    private Integer AdditionalPriceListId;

    public final Integer getItemId() {
        return (this.isInitialized()) ? this.ItemId:null;
    }

    public final void setItemId(final Integer ItemId) {
        this.ItemId = (this.isInitialized()) ? ItemId : this.ItemId;
    }

    public final Double getPriceInclusive() {
        return (this.isInitialized()) ? this.PriceInclusive:null;
    }

    public final void setPriceInclusive(final Double PriceInclusive) {
        this.PriceInclusive = (this.isInitialized()) ? PriceInclusive : this.PriceInclusive;
    }

    public final Double getPriceExclusive() {
        return (this.isInitialized()) ? this.PriceExclusive:null;
    }

    public final void setPriceExclusive(final Double PriceExclusive) {
        this.PriceExclusive = (this.isInitialized()) ? PriceExclusive : this.PriceExclusive;
    }

    public final Integer getAdditionalPriceListId() {
        return (this.isInitialized()) ? this.AdditionalPriceListId : null;
    }

    public final void setAdditionalPriceListId(final Integer AdditionalPriceListId) {
        this.AdditionalPriceListId = (this.isInitialized()) ? AdditionalPriceListId : this.AdditionalPriceListId;
    }
}
