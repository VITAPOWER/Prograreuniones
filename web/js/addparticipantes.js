/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var contador_para_invitados = 0;

function addparticipante(){
    var label1 = document.createElement("label");
    var label2 = document.createElement("label");
    var label3 = document.createElement("label");
    var label4 = document.createElement("label");
    
    var box1 = document.createElement("input");
    var box2 = document.createElement("input");
    var box3 = document.createElement("input");
    var box4 = document.createElement("input");
    
    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    var td4 = document.createElement("td");
    var td5 = document.createElement("td");
    var td6 = document.createElement("td");
    var td7 = document.createElement("td");
    var td8 = document.createElement("td");
    var tr = document.createElement("tr");
    
    var foo;
    var trline;
    var td1line;
    var td2line;
    var td3line;
    var td4line;
    var td5line;
    var td6line;
    var td7line;
    var td8line;
    var padre;
    
    label1.setAttribute("for", 'invitado' + contador_para_invitados);
    label1.setAttribute("class", 'label');
    label1.setAttribute("id", 'label1' + contador_para_invitados);
    
    label2.setAttribute("for", 'tagblock' + contador_para_invitados);
    label2.setAttribute("class", 'label');
    label2.setAttribute("id", 'label2' + contador_para_invitados);
    
    label3.setAttribute("for", 'tagevade' + contador_para_invitados);
    label3.setAttribute("class", 'label');
    label3.setAttribute("id", 'label3' + contador_para_invitados);
    
    label4.setAttribute("for", 'tagsupport' + contador_para_invitados);
    label4.setAttribute("class", 'label');
    label4.setAttribute("id", 'label4' + contador_para_invitados);
    
    box1.setAttribute("name", 'email');
    box1.setAttribute("type", 'text');
    box1.setAttribute("id", 'invitado' + contador_para_invitados);
    
    box2.setAttribute("name", 'bloquear');
    box2.setAttribute("type", 'text');
    box2.setAttribute("id", 'tagblock' + contador_para_invitados);
    box2.setAttribute("size", '4');
    
    box3.setAttribute("name", 'evitar');
    box3.setAttribute("type", 'text');
    box3.setAttribute("id", 'tagevade' + contador_para_invitados);
    box3.setAttribute("size", '4');
    
    box4.setAttribute("name", 'apoyar');
    box4.setAttribute("type", 'text');
    box4.setAttribute("id", 'tagsupport' + contador_para_invitados);
    box4.setAttribute("size", '4');
    
    td1.setAttribute("id", 'col1' + contador_para_invitados);
    td2.setAttribute("id", 'col2' + contador_para_invitados);
    td3.setAttribute("id", 'col3' + contador_para_invitados);
    td4.setAttribute("id", 'col4' + contador_para_invitados);
    td5.setAttribute("id", 'col5' + contador_para_invitados);
    td6.setAttribute("id", 'col6' + contador_para_invitados);
    td7.setAttribute("id", 'col7' + contador_para_invitados);
    td8.setAttribute("id", 'col8' + contador_para_invitados);
    tr.setAttribute("id", 'row' + contador_para_invitados);
    
    foo = document.getElementById("addpart");
    foo.appendChild(tr);
    
    trline = document.getElementById("row" + contador_para_invitados);
    trline.appendChild(td1);
    
    td1line = document.getElementById("col1" + contador_para_invitados);
    padre = td1line.parentNode;
    padre.insertBefore(td2, td1.nextSibling);
    td2line = document.getElementById("col2" + contador_para_invitados);
    padre.insertBefore(td3, td2.nextSibling);
    td3line = document.getElementById("col3" + contador_para_invitados);
    padre.insertBefore(td4, td3.nextSibling);
    td4line = document.getElementById("col4" + contador_para_invitados);
    padre.insertBefore(td5, td4.nextSibling);
    td5line = document.getElementById("col5" + contador_para_invitados);
    padre.insertBefore(td6, td5.nextSibling);
    td6line = document.getElementById("col6" + contador_para_invitados);
    padre.insertBefore(td7, td6.nextSibling);
    td7line = document.getElementById("col7" + contador_para_invitados);
    padre.insertBefore(td8, td7.nextSibling);
    td8line = document.getElementById("col8" + contador_para_invitados);
    
    td2line.appendChild(box1);
    td1line.appendChild(label1);
    td4line.appendChild(box2);
    td3line.appendChild(label2);
    td6line.appendChild(box3);
    td5line.appendChild(label3);
    td8line.appendChild(box4);
    td7line.appendChild(label4);
    
    
    document.getElementById("label1" + contador_para_invitados).innerHTML = "Mail";
    document.getElementById("label2" + contador_para_invitados).innerHTML = "# Block";
    document.getElementById("label3" + contador_para_invitados).innerHTML = "# Evade";
    document.getElementById("label4" + contador_para_invitados).innerHTML = "# Support";
    
    contador_para_invitados++;
}
