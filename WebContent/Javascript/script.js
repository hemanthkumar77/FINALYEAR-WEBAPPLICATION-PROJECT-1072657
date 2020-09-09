/**
 * 
 */

function func()
{
alert("datas has been saved ")
}

function check()
{
	 val1=document.getElementById("UN");
     er=document.getElementById("er1");
     exp1=/^[A-Z]{12}$/;
       if(val1.value=="")
			{
				er.innerHTML="please fill the username";
				return false;
			}
			else if(exp1.test(val1.value)==false)
			{
				er.innerHTML="ALL CAPS";
				val1.focus();
				return false;
			}
			else
			{
				er.innerHTML="";
			}
			
	 val2=document.getElementById("PA");
     er1=document.getElementById("er2");	
     exp2=/^[a-z]{3}[A-Z]{3}[0-9]{4}[@#$*!~]{2}$/;
	 if(val2.value=="")
			{
				er1.innerHTML="please fill the username";
				return false;
			}
			else if(exp2.test(val2.value)==false)
			{
				er1.innerHTML="example:hemANT2345@$ with ten characters";
				val2.focus();
				return false;
			}
			else
			{
				er1.innerHTML="";
			}
			
}