
/*
  	Dirty indicator to identify if the form has already been submitted.
	It is checked and set in the submitForm(url,Form) method and
  	is reset the customOnLoad method. 
*/
var isDirty = false;

/*
    Loads the specified url in the current window.
    
    @param url the url to post the form to.
    @return void.
 */
function submitUrl(url)
{  
  window.location.href = decodeAmpersand(url);
}

/*
    Posts the form to the specified url.
    
    @param url the url to post the form to.
    @parma form (optional) the form to post, if omitted the first form of the document is posted.
    @return void.
 */
function submitForm(url, form)
{  
  if(!isDirty){
  	isDirty = true;
    var myForm = form ? form : document.forms[0];
	myForm.action=decodeAmpersand(url);
	myForm.method="POST";
	if(myForm.onsubmit == null || myForm.onsubmit())
	{
	 $(myForm).trigger("submit");	
	}
	// reset dirty flag after 1000 ms
	setTimeout(resetDirty, 1000);
  }
  else
  {
  	/* Place holder for any action on double click. None for now */
  }
}

/*
  	Reset Dirty indicator as false.
 */
function resetDirty()
{
 isDirty = false;
}

/*
    Replaces all '&amp;' strings in the input and replaces them with '&'.
 */
function decodeAmpersand(input)
{
  var re = /&amp;/g;
  return input.replace(re, "&");
}