/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function loadcalendarios(){
    var calendar1 = document.createElement("a");
    var calendar2 = document.createElement("a");
    var calimg1 = document.createElement("img");
    var calimg2 = document.createElement("img");
    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    var td4 = document.createElement("td");
    var tr1 = document.createElement("tr");
    var tr2 = document.createElement("tr");
    var table1 = document.createElement("table");
    var table2 = document.createElement("table");
    
    calendar1.setAttribute("id",'calendar_tiempocreacion');
    calendar1.setAttribute("href", 'javascript:NewCal(\'tiempocreacion\',\'ddmmmyyyy\',true,24)');
    
    calendar2.setAttribute("id",'calendar_tiemporestante');
    calendar2.setAttribute("href", 'javascript:NewCal(\'tiemporestante\',\'ddmmmyyyy\',true,24)');
    
    calimg1.setAttribute("id", 'img1');
    calimg1.setAttribute("src", 'images/calendar/cal.gif');
    calimg1.setAttribute("width", '16');
    calimg1.setAttribute("height", '16');
    calimg1.setAttribute("border", '10');
    calimg1.setAttribute("alt", 'Escoge una fecha');
    
    calimg2.setAttribute("id", 'img2')
    calimg2.setAttribute("src", 'images/calendar/cal.gif');
    calimg2.setAttribute("width", '16');
    calimg2.setAttribute("height", '16');
    calimg2.setAttribute("border", '10');
    calimg2.setAttribute("alt", 'Escoge una fecha');
    
    td1.setAttribute("id", 'tdtiempocreacion');
    td2.setAttribute("id", 'tdtiemporestante');
    td3.setAttribute("id", 'tdtablatc');//los tds que faltaban para que se acomodara la tabla
    td4.setAttribute("id", 'tdtablatr');
    
    tr1.setAttribute("id", 'trtiempocreacion');
    tr2.setAttribute("id", 'trtiemporestante');
    
    table1.setAttribute("id", 'tabletiempocreacion');
    //table1.setAttribute("border", '0');
    //table1.setAttribute("width", '30%')
    //table1.setAttribute("class", 'wwFormTable');
    
    table2.setAttribute("id", 'tabletiemporestante');
    
    var foo = document.getElementById("tiempocreacion");
    var bar = document.getElementById("tiemporestante");
    
    
    var padre1 = foo.parentNode; //td
    var padre2 = bar.parentNode; //td
    var padre3 = padre1.parentNode; //tr
    var padre4 = padre2.parentNode; //tr
    
    var clon1 = padre1.cloneNode(true); //copia el td que tiene el input            //<td><input ...
    var clon2 = padre2.cloneNode(true);                                             //<td><input ...
    
    //debo insertar un td vecino y dentro del td el table
    padre3.insertBefore(td3, padre1.nextSibling);
    padre4.insertBefore(td4, padre2.nextSibling);
    
    var trtablatc = document.getElementById("tdtablatc");
    var trtablatr = document.getElementById("tdtablatr");
    
    trtablatc.appendChild(table1);
    trtablatr.appendChild(table2);
    
    var tabletiempocreacion = document.getElementById("tabletiempocreacion");       //<table></table>
    tabletiempocreacion.appendChild(tr1);                                           //<table><tr></tr></table>
    
    var trtiempocreacion = document.getElementById("trtiempocreacion");
    trtiempocreacion.appendChild(td1);                                              //<table><tr><td></td></tr></table>
    
    var idtd1 = document.getElementById("tdtiempocreacion");
    idtd1.appendChild(calendar1);                                                         //<table><tr><td><a></a></td></tr></table>
    
    var tabletiemporestante = document.getElementById("tabletiemporestante");
    tabletiemporestante.appendChild(tr2);
    
    var trtiemporestante = document.getElementById("trtiemporestante");
    trtiemporestante.appendChild(td2);
    
    var idtd2 = document.getElementById("tdtiemporestante");
    idtd2.appendChild(calendar2);
    
    //var idtd3 = document.getElementById("tdtiempocreacioncal");
    //var idtd4 = document.getElementById("tdtiemporestantecal");
    
    var idcalendar1 = document.getElementById("calendar_tiempocreacion");
    var idcalendar2 = document.getElementById("calendar_tiemporestante");
    
    idcalendar1.appendChild(calimg1);
    idcalendar2.appendChild(calimg2);
    
    padre3.removeChild(padre1)
    padre4.removeChild(padre2)
    
    trtiempocreacion.appendChild(clon1);
    //idtd3.appendChild(calendar1);
    
    trtiemporestante.appendChild(clon2);
    //idtd4.appendChild(calendar2);
    

}
