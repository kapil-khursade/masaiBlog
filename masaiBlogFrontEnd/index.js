// Banner div first

let arr = ["Story", "Experience", "Thoughts", "Feelings", "Motivation"];
let colors = ["green", "orange", "purple", "red", "blue"];
let index = 0;
document.querySelector("#Banner>div>span").innerText = arr[index];  
document.querySelector("#Banner>div>span").style.color=colors[index];
index++;
function returnElement() {
  document.querySelector("#Banner>div>span").innerText = arr[index];  
  document.querySelector("#Banner>div>span").style.color=colors[index];
  index = (index + 1) % arr.length;
}

setInterval(returnElement, 2500);