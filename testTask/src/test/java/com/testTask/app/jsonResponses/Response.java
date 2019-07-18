package com.testTask.app.jsonResponses;

public class Response {
	    private String CategoryId;

	    private String Path;

	    private Promotions[] Promotions;

	    private String[] EmbeddedContentOptions;

	    private String[] AllowedDurations;

	    private String IsFreeToRelist;

	    private String CanListAuctions;

	    private Fees Fees;

	    private String Name;

	    private String CanListClassifieds;

	    private String AreaOfBusiness;

	    private String DefaultRelistDuration;

	    private String MaximumPhotoCount;

	    private String CanRelist;

	    private String LegalNotice;

	    private String DefaultDuration;

	    private String MaximumTitleLength;

	    private String FreePhotoCount;

	    public String getCategoryId ()
	    {
	        return CategoryId;
	    }

	    public void setCategoryId (String CategoryId)
	    {
	        this.CategoryId = CategoryId;
	    }

	    public String getPath ()
	    {
	        return Path;
	    }

	    public void setPath (String Path)
	    {
	        this.Path = Path;
	    }

	    public Promotions[] getPromotions ()
	    {
	        return Promotions;
	    }

	    public void setPromotions (Promotions[] Promotions)
	    {
	        this.Promotions = Promotions;
	    }

	    public String[] getEmbeddedContentOptions ()
	    {
	        return EmbeddedContentOptions;
	    }

	    public void setEmbeddedContentOptions (String[] EmbeddedContentOptions)
	    {
	        this.EmbeddedContentOptions = EmbeddedContentOptions;
	    }

	    public String[] getAllowedDurations ()
	    {
	        return AllowedDurations;
	    }

	    public void setAllowedDurations (String[] AllowedDurations)
	    {
	        this.AllowedDurations = AllowedDurations;
	    }

	    public String getIsFreeToRelist ()
	    {
	        return IsFreeToRelist;
	    }

	    public void setIsFreeToRelist (String IsFreeToRelist)
	    {
	        this.IsFreeToRelist = IsFreeToRelist;
	    }

	    public String getCanListAuctions ()
	    {
	        return CanListAuctions;
	    }

	    public void setCanListAuctions (String CanListAuctions)
	    {
	        this.CanListAuctions = CanListAuctions;
	    }

	    public Fees getFees ()
	    {
	        return Fees;
	    }

	    public void setFees (Fees Fees)
	    {
	        this.Fees = Fees;
	    }

	    public String getName ()
	    {
	        return Name;
	    }

	    public void setName (String Name)
	    {
	        this.Name = Name;
	    }

	    public String getCanListClassifieds ()
	    {
	        return CanListClassifieds;
	    }

	    public void setCanListClassifieds (String CanListClassifieds)
	    {
	        this.CanListClassifieds = CanListClassifieds;
	    }

	    public String getAreaOfBusiness ()
	    {
	        return AreaOfBusiness;
	    }

	    public void setAreaOfBusiness (String AreaOfBusiness)
	    {
	        this.AreaOfBusiness = AreaOfBusiness;
	    }

	    public String getDefaultRelistDuration ()
	    {
	        return DefaultRelistDuration;
	    }

	    public void setDefaultRelistDuration (String DefaultRelistDuration)
	    {
	        this.DefaultRelistDuration = DefaultRelistDuration;
	    }

	    public String getMaximumPhotoCount ()
	    {
	        return MaximumPhotoCount;
	    }

	    public void setMaximumPhotoCount (String MaximumPhotoCount)
	    {
	        this.MaximumPhotoCount = MaximumPhotoCount;
	    }

	    public String getCanRelist ()
	    {
	        return CanRelist;
	    }

	    public void setCanRelist (String CanRelist)
	    {
	        this.CanRelist = CanRelist;
	    }

	    public String getLegalNotice ()
	    {
	        return LegalNotice;
	    }

	    public void setLegalNotice (String LegalNotice)
	    {
	        this.LegalNotice = LegalNotice;
	    }

	    public String getDefaultDuration ()
	    {
	        return DefaultDuration;
	    }

	    public void setDefaultDuration (String DefaultDuration)
	    {
	        this.DefaultDuration = DefaultDuration;
	    }

	    public String getMaximumTitleLength ()
	    {
	        return MaximumTitleLength;
	    }

	    public void setMaximumTitleLength (String MaximumTitleLength)
	    {
	        this.MaximumTitleLength = MaximumTitleLength;
	    }

	    public String getFreePhotoCount ()
	    {
	        return FreePhotoCount;
	    }

	    public void setFreePhotoCount (String FreePhotoCount)
	    {
	        this.FreePhotoCount = FreePhotoCount;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [CategoryId = "+CategoryId+", Path = "+Path+", Promotions = "+Promotions+", EmbeddedContentOptions = "+EmbeddedContentOptions+", AllowedDurations = "+AllowedDurations+", IsFreeToRelist = "+IsFreeToRelist+", CanListAuctions = "+CanListAuctions+", Fees = "+Fees+", Name = "+Name+", CanListClassifieds = "+CanListClassifieds+", AreaOfBusiness = "+AreaOfBusiness+", DefaultRelistDuration = "+DefaultRelistDuration+", MaximumPhotoCount = "+MaximumPhotoCount+", CanRelist = "+CanRelist+", LegalNotice = "+LegalNotice+", DefaultDuration = "+DefaultDuration+", MaximumTitleLength = "+MaximumTitleLength+", FreePhotoCount = "+FreePhotoCount+"]";
	    }
}
