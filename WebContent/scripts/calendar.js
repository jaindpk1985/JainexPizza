
  // Open the popup Calendar and give it access to the target input.  The optional array
  // parameter 'limits' defines a range of selectable dates, relative to today.
  // For example the array [-4,10] means any date from 4 days ago to 10 days in the future
  // is selectable.  The first integer must be less than the second.  Note: [0,1] is two
  // days (today and tomorrow).  If limits is missing, all dates are selectable.
  function calendarPopup (theInput, limits) {
    this.calendarInput = theInput;    // this == window
    this.yearScroll = true;
    var today = new Date();
    if (limits && limits[0] <= limits[1]) {
      var firstDate = new Date(today);
      firstDate.setDate(firstDate.getDate() + limits[0]);
      this.firstSelectableDate = firstDate;
      var lastDate = new Date(today);
      lastDate.setDate(lastDate.getDate() + limits[1]);
      this.lastSelectableDate = lastDate;
    }
    var popup = window.open('scripts/calendar.html?datetime=' + today.valueOf(),
	    'Calendar', 'width=200,height=215,status=no,resizable=no,top=200,left=200,dependent=yes,alwaysRaised=yes' );
    popup.focus();		
  }
  
  // Called by calendar popup.  Convert date to mm/dd/yyyy format and set the target input.
  function calendarSave(dateMillis) {
    var saveDate = new Date(dateMillis);
    window.calendarInput.value = 
          (saveDate.getMonth() < 9 ? '0' : '') + (saveDate.getMonth() + 1) + "/" + 
          (saveDate.getDate() < 10 ? '0' : '') + saveDate.getDate() + "/" + saveDate.getFullYear()
    
    //This was commented out as a conflict
    window.calendarInput.style.color = '#000000';
    setPageModified();  
  }

