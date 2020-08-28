function createEmpSalaryStructure() {
	var search = $("#cTC").val();
	//alert(search);
	 if(search.length>3){  
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/calBasicSalary",
        data: search,
        dataType: 'json',
        cache: false,
        success : function(response) {
            console.log("success : "+response.basicSalaryYearly);
            $('#annualBasicSalary').val(response.basicSalaryYearly);
            $('#pf').val(response.pfYearly);
            $('#hra').val(response.hraYearly);
            $('#convey').val(response.conveyanceYearly);
            $('#annualFlexibleBenifits').val(response.otherYearly);
            $('#annualRefSalary').val(response.annualRefSalary);
            $('#esi').val(response.esiYearly);
        },
        
		 error : function(error) {
			 console.log("basicSalaryYearly "+JSON.stringify(error.basicSalaryYearly));
	        console.log("error : "+JSON.stringify(error));
	     }

	});
	 }
};

function showNextTaxStep(nextTaxStep) {
    $('.taxStyle').each(function(index) {
         if ($(this).attr("id") == nextTaxStep) {
              $(this).show(200);
         }
         else {
              $(this).hide(600);
         }
    });
}

function openTaxTab(evt, taxDetails) {
	  var i, taxStyle, tablinks;
	  taxStyle = document.getElementsByClassName("taxStyle");
	  for (i = 0; i < taxStyle.length; i++) {
		  taxStyle[i].style.display = "none";
	  }
	  tablinks = document.getElementsByClassName("tablinks");
	  for (i = 0; i < tablinks.length; i++) {
	    tablinks[i].className = tablinks[i].className.replace(" active", "");
	  }
	  document.getElementById(taxDetails).style.display = "block";
	  evt.currentTarget.className += " active";
	}

$("#mytable #checkall").click(function () {
    if ($("#mytable #checkall").is(':checked')) {
        $("#mytable input[type=checkbox]").each(function () {
            $(this).prop("checked", true);
        });

    } else {
        $("#mytable input[type=checkbox]").each(function () {
            $(this).prop("checked", false);
        });
    }
});

$("#searchBar").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#salaryRevisionTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });

var Id;
$( "#employeeId" ).load($(this),function employeeInfo(Id) {
	var search = $("#employeeId").val();
	alert("========="+Id);
	alert("========="+Id.value);
	var url = '/getEmployeeDetails/' + Id.value;	
	$.ajax({
	      url: url,
	      data: {}, //parameters go here in object literal form
	      type: 'GET',
	      datatype: 'json',
	      success: function(data) { alert('got here with data'); },
	      error: function() { alert('something bad happened'); }
	    });
});

function exportTimeSheetForm() {
	  document.getElementById("myForm").style.display = "block";
	}

function closeForm() {
	  document.getElementById("myForm").style.display = "none";
	}