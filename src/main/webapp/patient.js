var idSelected=undefined;

var listPatiences = [];
var printIcon = function(cell, formatterParams){ //plain text value
    return "<i class='fa fa-trash'></i>";
};
console.log("listPatience",listPatiences);
var tablePatiences = new Tabulator("#patient-list", {
    height:"500px",
    reactiveData:true,
    data:listPatiences, //set initial table data
    layout:"fitColumns",
    selectable:true,
    pagination:"local",
    paginationSize:6,
    paginationSizeSelector:[3, 6, 8, 10],
    rowClick:function(e, row){
        //e - the click event object
        //row - row component
        console.log("row",row);
        idSelected=row._row.data.id;
        console.log("idSelected",idSelected);
        document.getElementById("firstName").value=row._row.data.firstName;
        document.getElementById("lastName").value=row._row.data.lastName;
        document.getElementById("age").value=row._row.data.age;
        document.getElementById("gender").value=row._row.data.gender;
        row.toggleSelect(); //toggle row selected state on row click
    },
    columns:[
        {
            formatter: printIcon, width:40, align:"center", cellClick:function(e, cell){
            //alert("Printing row data for: " + cell.getRow().getData().name)
                deleteRow(cell);
        }
        },
        {title:"ID",field:'id'},
        {title:"Name", field:"firstName"},
        {title: "Lastname", field: "lastName"},
        {title:"Age", field:"age"},
        {title:"Gender", field:"gender"},
    ],
});


tablePatiences.replaceData(listPatiences);

getAllPatiences();

function getAllPatiences(){
    axios.get('/patient')
  .then(function (response) {
    // handle success
    // {id:1, name:"Willian", lastname:"Ruiz Diaz",age:"32", blood_presure:"12-8",heart_rate:"12"},
    // {id:2, name:"Mercedes", lastname:"Fonseca", age:"64", blood_presure:"12-8", heart_rate:"8"},
    console.log(response);
    listPatiences=response.data;
    tablePatiences.replaceData(listPatiences);
  })
  .catch(function (error) {
    // handle error
    console.log(error);
  })
  .then(function () {
    // always executed
  });
}

function saveOrUpdateData(){
    console.log("saveOrUpdateData");
    var firstName=document.getElementById("firstName").value;
    var lastName=document.getElementById("lastName").value;
    var age=document.getElementById("age").value;
    var gender=document.getElementById("gender").value;
    //create new
    if(idSelected != undefined){
        tablePatiences.updateData([{id:idSelected, firstName:firstName, age:age, lastName: lastName, gender: gender}]);
    }else{
        //we must calculate the id, that is the sum from the id's plus one
        var newId=calculateId();
        var param={id:newId, firstName:firstName, age:age, lastName: lastName, gender: gender};
        axios.post('/patient', param)
          .then(function (response) {
            console.log(response);
            tablePatiences.addData([param]);
              $('.collapse').toggle();
            alert("Patient added sucessfully");
          })
          .catch(function (error) {
            console.log(error);
          });

    }

}

function calculateId(){
    sum=0;
    tablePatiences.getData().forEach(function(value,index){
        sum=value.id;
    });
    return sum+1;
}

function deleteRow(cell){
    
    axios.delete('/patient/'+cell.getRow().getData().id)
    .then(function (response) {
        alert("Patience deleted: " + cell.getRow().getData().firstName)
        tablePatiences.deleteRow(cell.getRow().getData().id);
    })
    .catch(function (error) {
        // handle error
        console.log(error);
    })
    .then(function () {
        // always executed
    });
}
    

function filterByName(){
    console.log("filterByName");
    var name=document.getElementById("patientName").value;
    console.log(name);

    // let found = tablePatiences.getData().find(element => element==name);
    // console.log("found", found);
    var result=tablePatiences.getData().filter(function(value,index){
        return value.firstName == name;
    });
    console.log("result",result);
    tablePatiences.setData(result);


}


function clearFilter(){
    document.getElementById("patientName").value="";
    // document.getElementById("dateFrom").value=new Date();
    // document.getElementById("dateTo").value=new Date();
    getAllPatiences();
}
