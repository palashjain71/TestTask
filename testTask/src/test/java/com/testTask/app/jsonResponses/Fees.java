package com.testTask.app.jsonResponses;

public class Fees
{
    private String Reserve;

    private String Subtitle;

    private ListingFeeTiers[] ListingFeeTiers;

    private String Listing;

    private String Bundle;

    private String Gallery;

    private String TenDays;

    private String EndDate;

    private String Feature;

    private String SecondCategory;

    public String getReserve ()
    {
        return Reserve;
    }

    public void setReserve (String Reserve)
    {
        this.Reserve = Reserve;
    }

    public String getSubtitle ()
    {
        return Subtitle;
    }

    public void setSubtitle (String Subtitle)
    {
        this.Subtitle = Subtitle;
    }

    public ListingFeeTiers[] getListingFeeTiers ()
    {
        return ListingFeeTiers;
    }

    public void setListingFeeTiers (ListingFeeTiers[] ListingFeeTiers)
    {
        this.ListingFeeTiers = ListingFeeTiers;
    }

    public String getListing ()
    {
        return Listing;
    }

    public void setListing (String Listing)
    {
        this.Listing = Listing;
    }

    public String getBundle ()
    {
        return Bundle;
    }

    public void setBundle (String Bundle)
    {
        this.Bundle = Bundle;
    }

    public String getGallery ()
    {
        return Gallery;
    }

    public void setGallery (String Gallery)
    {
        this.Gallery = Gallery;
    }

    public String getTenDays ()
    {
        return TenDays;
    }

    public void setTenDays (String TenDays)
    {
        this.TenDays = TenDays;
    }

    public String getEndDate ()
    {
        return EndDate;
    }

    public void setEndDate (String EndDate)
    {
        this.EndDate = EndDate;
    }

    public String getFeature ()
    {
        return Feature;
    }

    public void setFeature (String Feature)
    {
        this.Feature = Feature;
    }

    public String getSecondCategory ()
    {
        return SecondCategory;
    }

    public void setSecondCategory (String SecondCategory)
    {
        this.SecondCategory = SecondCategory;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Reserve = "+Reserve+", Subtitle = "+Subtitle+", ListingFeeTiers = "+ListingFeeTiers+", Listing = "+Listing+", Bundle = "+Bundle+", Gallery = "+Gallery+", TenDays = "+TenDays+", EndDate = "+EndDate+", Feature = "+Feature+", SecondCategory = "+SecondCategory+"]";
    }
}
			