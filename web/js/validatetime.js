/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function comparatiemposgrupo(casilla1, casilla2){
    //ejemplo date 2011-02-09 11:28:29
    //             0123456789
    var temp1="";
    var temp2="";
    var str1 = casilla1; 
    var str2 = casilla2; 
    var anio1  = str1.substring(0,4); 
    var mes1 = str1.substring(5,7); 
    var dia1  = str1.substring(8,10);  
    var anio2  = str2.substring(0,4); 
    var mes2 = str2.substring(5,7); 
    var dia2  = str2.substring(8,10);   
    temp1 = anio1 +"-"+ mes1 +"-"+ dia1;
    temp2 = anio2 +"-"+ mes2 +"-"+ dia2;
    
    var hora1;
    var minuto1;
    var segundo1;
    var hora2;
    var minuto2;
    var segundo2;


    var cfd = Date.parse(temp1);
    var ctd = Date.parse(temp2);


    var date1 = new Date(cfd); 
    var date2 = new Date(ctd);




    if(date1 > date2) 
    { 
        alert("FROM DATE SHOULD BE MORE THAN TO DATE");
    }
}
