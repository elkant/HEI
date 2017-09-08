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
        $('#wizard').smartWizard('showMessage','Please correct the errors in the steps and continue');
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
    
   
        
    return isStepValid;
}
		
function validateStep1(){
    
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
    
 
     


 if(1==1){
       
 
       
       }

    
    else{
       
    }
    return isValid;
}
    
 //==================validate step 3   
  function validateStep3(){
        
      var isValid = true; 
    // Validate Username
    
   
     
   
    
 if(1==1){
       
       
    }

    
    else{
       
    }
    return isValid;
    }


   
 //==================validate step 4   
function validateStep4(){
        
  
   
    
    
    
 



 if(1==1){
        
       
    }

    
    else{
       
    }
    return true;
}


//===================validate step 5    
    function validateStep5(){
       
   

 if(1==1){
      
       
    }

    
    else{
       
    }
    return true;
    }
//================validate step 7=========================================================================
    
