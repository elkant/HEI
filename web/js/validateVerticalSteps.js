/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    // Smart Wizard     	
    $('#wizard').smartWizard({
        transitionEffect:'slideleft',
        onLeaveStep:leaveAStepCallback,
        onFinish:onFinishCallback,
        enableFinishButton:true
    });

    function leaveAStepCallback(obj){
        var step_num= obj.attr('rel');
        return validateSteps(step_num);
    }
      
    function onFinishCallback(){
        if(validateAllSteps()){
            $('form').submit();
        }
    }
            
});
	   
function validateAllSteps(){
    var isStepValid = true;
       
    if(validateStep1() == false){
        isStepValid = false;
        $('#wizard').smartWizard('setError',{
            stepnum:1,
            iserror:true
        });         
    }else{
        $('#wizard').smartWizard('setError',{
            stepnum:1,
            iserror:false
        });
    }
     
   //===== 2 
     
        if(validateStep2() == false){
        isStepValid = false;
        $('#wizard').smartWizard('setError',{
            stepnum:2,
            iserror:true
        });         
    }else{
        $('#wizard').smartWizard('setError',{
            stepnum:2,
            iserror:false
        });
    }
      
     
   //======= 3 
     
    if(validateStep3() == false){
        isStepValid = false;
        $('#wizard').smartWizard('setError',{
            stepnum:3,
            iserror:true
        });         
    }else{
        $('#wizard').smartWizard('setError',{
            stepnum:3,
            iserror:false
        });
    }
       
//=========4       
          if(validateStep4() == false){
        isStepValid = false;
        $('#wizard').smartWizard('setError',{
            stepnum:4,
            iserror:true
        });         
    }else{
        $('#wizard').smartWizard('setError',{
            stepnum:4,
            iserror:false
        });
    }
      
  //====5
     if(validateStep5() == false){
        isStepValid = false;
        $('#wizard').smartWizard('setError',{
            stepnum:5,
            iserror:true
        });         
    }else{
        $('#wizard').smartWizard('setError',{
            stepnum:5,
            iserror:false
        });
    }
      
      
      
      
     
    if(!isStepValid){
        $('#wizard').smartWizard('showMessage','<font color="red">Quality Checks 2nd Review : Please ensure the sum of numerators of <br> 16.1 to 16,6 is equal to denominator of 16.1</font>');
    }
              
    return isStepValid;
} 	
		
		
function validateSteps(step){
    var isStepValid = true;
    // validate step 1
    if(step == 1){
        if(validateStep1() == false ){
            isStepValid = false; 
            $('#wizard').smartWizard('showMessage','Please correct the errors in step'+step+ ' and click next.');
            $('#wizard').smartWizard('setError',{
                stepnum:step,
                iserror:true
            });         
        }else{
            load_saved_data();
            $('#wizard').smartWizard('hideMessage');
            $('#wizard').smartWizard('setError',{
                stepnum:step,
                iserror:false
            });
        }
    }
    //validate step 2
    if(step == 2){
        if(validateStep2() == false ){
            isStepValid = false; 
            $('#wizard').smartWizard('showMessage','Please correct the errors in step'+step+ ' and click next.');
            $('#wizard').smartWizard('setError',{
                stepnum:step,
                iserror:true
            });         
        }else{
            $('#wizard').smartWizard('hideMessage');
            $('#wizard').smartWizard('setError',{
                stepnum:step,
                iserror:false
            });
        }
    }
      
      
      
    //validate step3
    if(step == 3){
        if(validateStep3() == false ){
            isStepValid = false; 
            $('#wizard').smartWizard('showMessage','<font color="red">Quality Checks 1st Review : Ensure the sum of numerators of <br> 11.1 to 11.5 is equal to the value of denominator of 11.1</font>');
            $('#wizard').smartWizard('setError',{
                stepnum:step,
                iserror:true
            });         
        }else{
            $('#wizard').smartWizard('hideMessage');
            $('#wizard').smartWizard('setError',{
                stepnum:step,
                iserror:false
            });
        }
    }
    
    
    
     //validate step4
    if(step == 4){
        if(validateStep4() == false ){
            isStepValid = false; 
            $('#wizard').smartWizard('showMessage','Please correct the errors in step'+step+ ' and click next.');
            $('#wizard').smartWizard('setError',{
                stepnum:step,
                iserror:true
            });         
        }else{
            $('#wizard').smartWizard('hideMessage');
            $('#wizard').smartWizard('setError',{
                stepnum:step,
                iserror:false
            });
        }
    }
    
    
    //validate step 5
    if(step == 5){
        if(validateStep5() == false ){
            isStepValid = false; 
            $('#wizard').smartWizard('showMessage','<font color="red">Quality Checks 2nd Review : Please ensure the sum of numerators of <br> 16.1 to 16,6 is equal to denominator of 16.1</font>');
            $('#wizard').smartWizard('setError',{
                stepnum:step,
                iserror:true
            });         
        }else{
            $('#wizard').smartWizard('hideMessage');
            $('#wizard').smartWizard('setError',{
                stepnum:step,
                iserror:false
            });
        }
    }
    
   
        
    return isStepValid;
}
		
function validateStep1(){
    validates_qc();  
    var isValid = true; 
    // Validate Username
    
   
   var county=$('#county').val();  
   var district=$('#district').val();  
   var facil=$('#facility').val();  
   var month=$('#month').val();  
   var year=$('#year').val();  
   
 if(county==""){
        isValid = false;
        //alert("Enter facility");
       $("#county").css("border-color","#ff0000");
       $("#county").slideToggle("slow",function() {});
       $("#county").slideToggle("slow",function() {}); 
       $("#county").focus();
         $("#msg").html('Select County');
    // alert("anc needed");
       
          }
 else if(district==""){
        isValid = false;
        //alert("Enter facility");
       $("#district").css("border-color","#ff0000");
       $("#district").slideToggle("slow",function() {});
       $("#district").slideToggle("slow",function() {}); 
       $("#district").focus();
       $("#msg").html('Select District');
    // alert("anc needed");
       
          }

else if(facil==""){
        isValid = false;
        //alert("Enter facility");
       $("#facility").css("border-color","#ff0000");
       $("#facility").slideToggle("slow",function() {});
       $("#facility").slideToggle("slow",function() {}); 
       $("#facility").focus();
         $("#msg").html('Select Facility');
    // alert("anc needed");
       
          }
    
    else if(year==""){
        isValid = false;
        
       $("#year").css("border-color","#ff0000");
       $("#year").slideToggle("slow",function() {});
       $("#year").slideToggle("slow",function() {}); 
       $("#year").focus();
       $("#msg").html('Select Cohort birth Year');
    // alert("anc needed");
       
          }
          
          
          else if(month==""){
        isValid = false;
       // alert("Enter Month");
       $("#month").css("border-color","#ff0000");
       $("#month").slideToggle("slow",function() {});
       $("#month").slideToggle("slow",function() {}); 
       $("#month").focus();
         $("#msg").html('Select Month');
    // alert("anc needed");
       
          }
    
    
    else{
        $("#county").css("border-color","#777");
        $("#district").css("border-color","#777");
        $("#facility").css("border-color","#777");
        $("#month").css("border-color","#777");
        $("#year").css("border-color","#777");
        $("#msg").html('').hide();
    }
    return isValid;
}


 //=====================validate step 2
    function validateStep2(){
  var isValid = true; 
    // Validate Username
    validates_qc();  
 
     


 if(1==1){
       
 
       
       }

    
    else{
       
    }
    return isValid;
}
    
 //==================validate step 3   
  function validateStep3(){
       validates_qc();   
                        
      var isValid = true; 
    // Validate Username
    var value = document.getElementById("qc1").value.trim();
    if(value!="1"){
     isValid = false;   
    }
   
    return isValid;
    }


   
 //==================validate step 4   
function validateStep4(){
    validates_qc();      
  
 if(1==1){
        
       
    }

    
    else{
       
    }
    return true;
}


//===================validate step 5    
    function validateStep5(){
         validates_qc();    
      var isValid = true; 
    // Validate Username
    var value = document.getElementById("qc2").value.trim();
    if(value!="1"){
     isValid = false;   
    }
   
    return isValid;
    }
//================validate step 7=========================================================================
  
    function validates_qcw(){

    }
    
    function validates_qc(){
        var A=0,d_11=0,d_12=0,d_13=0,d_14=0,d_15=0;
        var F=0,d_21=0,d_22=0,d_23=0,d_24=0,d_25=0,d_26=0;
        
        var den_1 = document.getElementById("den_1");
        var num_11 = document.getElementById("num_11");
        var num_12 = document.getElementById("num_12");
        var num_13 = document.getElementById("num_13");
        var num_14 = document.getElementById("num_14");
        var num_15 = document.getElementById("num_15");
                
                
         if (typeof(den_1) != 'undefined' && den_1 != null && typeof(num_11) != 'undefined' && num_11 != null && typeof(num_12) != 'undefined' && num_12 != null && typeof(num_13) != 'undefined' && num_13 != null && typeof(num_14) != 'undefined' && num_14 != null && typeof(num_15) != 'undefined' && num_15 != null){
        A=parseInt(document.getElementById("den_1").value);
        if(document.getElementById("num_11").value!=""){d_11=document.getElementById("num_11").value; }   
        if(document.getElementById("num_12").value!=""){d_12=document.getElementById("num_12").value; }   
        if(document.getElementById("num_13").value!=""){d_13=document.getElementById("num_13").value; }   
        if(document.getElementById("num_14").value!=""){d_14=document.getElementById("num_14").value;}    
        if(document.getElementById("num_15").value!=""){d_15=document.getElementById("num_15").value;}    

        var sum=parseInt(d_11)+parseInt(d_12)+parseInt(d_13)+parseInt(d_14)+parseInt(d_15);
        var message="";
        if(sum!=A){
         message="0" ;  
        }
        else{
          message="1" ;     
        }
        document.getElementById("qc1").value=message; 
        }
    
        var den_21 = document.getElementById("den_21");
        var num_21 = document.getElementById("num_21");
        var num_22 = document.getElementById("num_22");
        var num_23 = document.getElementById("num_23");
        var num_24 = document.getElementById("num_24");
        var num_25 = document.getElementById("num_25");
        var num_26 = document.getElementById("num_26");
        
     if (typeof(den_21) != 'undefined' && den_21 != null && typeof(num_21) != 'undefined' && num_21 != null && typeof(num_22) != 'undefined' && num_22 != null && typeof(num_23) != 'undefined' && num_23 != null && typeof(num_24) != 'undefined' && num_24 != null && typeof(num_25) != 'undefined' && num_25 != null && typeof(num_26) != 'undefined' && num_26 != null){
                    F=parseInt(document.getElementById("den_21").value);
                    if(document.getElementById("num_21").value!=""){d_21=document.getElementById("num_21").value; }   
                    if(document.getElementById("num_22").value!=""){d_22=document.getElementById("num_22").value; }   
                    if(document.getElementById("num_23").value!=""){d_23=document.getElementById("num_23").value; }   
                    if(document.getElementById("num_24").value!=""){d_24=document.getElementById("num_24").value;}    
                    if(document.getElementById("num_25").value!=""){d_25=document.getElementById("num_25").value;}    
                    if(document.getElementById("num_26").value!=""){d_26=document.getElementById("num_26").value;}    
                    
                    var sum=parseInt(d_21)+parseInt(d_22)+parseInt(d_23)+parseInt(d_24)+parseInt(d_25)+parseInt(d_26);
                    var message="";
                    
                    if(sum!=F){
                     message="0" ;  
                    }
                    else{
                      message="1" ;     
                    }
                    document.getElementById("qc2").value=message;
                }
}
