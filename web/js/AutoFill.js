/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function fillA(){
var value_entered=document.getElementById("den_1").value;

document.getElementById("den_2").value=value_entered; 
document.getElementById("den_3").value=value_entered;
document.getElementById("den_5").value=value_entered;
document.getElementById("den_11").value=value_entered;
document.getElementById("den_12").value=value_entered;
document.getElementById("den_13").value=value_entered;
document.getElementById("den_14").value=value_entered;
document.getElementById("den_15").value=value_entered;


//fillF2(value_entered);
}


function fillB(){
 var value_entered=document.getElementById("num_3").value;

document.getElementById("den_4").value=value_entered;

}


function fillC(){
var value_entered=document.getElementById("num_7").value;

document.getElementById("den_9").value=value_entered;
document.getElementById("den_10").value=value_entered;
}


function fillD(){
var value_entered=document.getElementById("num_16").value;

document.getElementById("den_17").value=value_entered;
}


function fillE(){
 var value_entered=document.getElementById("den_20").value; 

document.getElementById("num_23").value=value_entered;
}

function fillF(){
 var value_entered=document.getElementById("den_21").value; 
 fillF2(value_entered);
}


function fillF2(value_entered){
 document.getElementById("den_21").value=value_entered;
 document.getElementById("den_22").value=value_entered;
 document.getElementById("den_23").value=value_entered;
 document.getElementById("den_24").value=value_entered;
 document.getElementById("den_25").value=value_entered;
 document.getElementById("den_26").value=value_entered;
}



