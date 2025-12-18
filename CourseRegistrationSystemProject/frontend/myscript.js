function showCourses(){
    fetch("http://localhost:8080/availCourses").then((response)=> response.json()).then((courses)=>{
        const dataTable = document.getElementById("courses");

        courses.forEach(course =>{
            var row = `<tr>
            <td>${course.courseName}</td>
            <td>${course.trainer}</td>
            <td>${course.durationInWeeks}</td>
            </tr>`

            dataTable.innerHTML += row;

        })
    })
}

function showEnroll(){
    fetch("http://localhost:8080/getCourseRegistry").then((response)=>response.json()).then((datas)=>{
         const enrol = document.getElementById("tablecourse")
         
         datas.forEach((data)=>{
            var row = `<tr>
            <td>${data.name}</td>
            <td>${data.emailId}</td>
            <td>${data.courseName}</td>
            </tr>`

            enrol.innerHTML += row;
         })
    })
}