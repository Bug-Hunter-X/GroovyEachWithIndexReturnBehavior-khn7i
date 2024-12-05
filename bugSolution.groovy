```groovy
def myMethod(List<String> list) {
  list.eachWithIndex { item, index ->
    println "Item $index: $item"
    if (item == "stop") {
      return false //Return a value from the eachWithIndex loop
    }
  }
  println "Finished processing list"
}

myMethod(["one", "two", "stop", "four"])

//Alternative solution using find

def myMethod2(List<String> list){
  list.findIndexOf {it == "stop"}.with {index->
    if(index != -1){
        println "Item $index: stop"
        return
    }else{
        list.eachWithIndex {item,index-> println "Item $index: $item"}
    }
  }
}
myMethod2(["one","two","stop","four"])

//Alternative solution using findResult

def myMethod3(List<String> list) {
    def result = list.findResult { it ->
        println "Item: $it"
        if (it == "stop") {
            return "Stop found!"
        }
        null
    }
    if(result){
        println result
    }else{
        println "Finished processing list"
    }
}
myMethod3(["one", "two", "stop", "four"])
```