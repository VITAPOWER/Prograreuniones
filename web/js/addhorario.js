/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var contador = 0;

function addhr() {
    //Create an input type dynamically.
    var element = document.createElement("input");
    var element2 = document.createElement("input");
    var calendar = document.createElement("a");
    var calendar2 = document.createElement("a");
    var calimg = document.createElement("img");
    var calimg2 = document.createElement("img");
    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    var td4 = document.createElement("td");
    var tr = document.createElement("tr");
    
    var p = document.createElement("p");
    
    //Assign different attributes to the element.
    
    element.setAttribute("id", 'desde' + contador);
    element.setAttribute("type", 'text');
    element.setAttribute("value", 'desde');
    element.setAttribute("name", 'fechainicio');
    
    element2.setAttribute("id", 'hasta' + contador);
    element2.setAttribute("type", 'text');
    element2.setAttribute("value", 'hasta');
    element2.setAttribute("name", 'fechafin');
    
    calendar.setAttribute("id",'caldesde' + contador);
    calendar.setAttribute("href", 'javascript:NewCal(\'desde' + contador + '\',\'ddmmyyyy\',true,24)');
    
    calendar2.setAttribute("id",'calhasta' + contador);
    calendar2.setAttribute("href", 'javascript:NewCal(\'hasta' + contador + '\',\'ddmmyyyy\',true,24)');
    
    calimg.setAttribute("src", 'images/calendar/cal.gif');
    calimg.setAttribute("width", '16');
    calimg.setAttribute("height", '16');
    calimg.setAttribute("border", '10');
    calimg.setAttribute("alt", 'Escoge una fecha');
    
    calimg2.setAttribute("src", 'images/calendar/cal.gif');
    calimg2.setAttribute("width", '16');
    calimg2.setAttribute("height", '16');
    calimg2.setAttribute("border", '10');
    calimg2.setAttribute("alt", 'Escoge una fecha');

    td1.setAttribute("id", 'td1' + contador);
    td2.setAttribute("id", 'td2' + contador);
    td3.setAttribute("id", 'td3' + contador);
    td4.setAttribute("id", 'td4' + contador);
    tr.setAttribute("id", 'tr' + contador);

    var foo = document.getElementById("fooBar");
    
    foo.appendChild(tr);
    var trline = document.getElementById("tr" + contador);
    
    trline.appendChild(td1);
    var td1line = document.getElementById("td1" + contador);
    var padre = td1line.parentNode; //padre es tr
    padre.insertBefore(td2, td1.nextSibling);
    var td2line = document.getElementById("td2" + contador);
    padre.insertBefore(td3, td2.nextSibling);
    var td3line = document.getElementById("td3" + contador);
    padre.insertBefore(td4, td3.nextSibling);
    var td4line = document.getElementById("td4" + contador);
    //Append the element in page (in td).
    td1line.appendChild(element);
    td2line.appendChild(calendar);
    
    var cal1 = document.getElementById("caldesde" + contador);
    cal1.appendChild(calimg);
    
    
    td3line.appendChild(element2);
    td4line.appendChild(calendar2);
    
    var cal2 = document.getElementById("calhasta" + contador);
    cal2.appendChild(calimg2);
    
    //foo.appendChild(p);
    
    contador++;
 
}