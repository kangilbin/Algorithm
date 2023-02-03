function getTimestampsByDescription(xml, description) {
  let parser = new DOMParser();
  var xmlDoc = parser.parseFromString(xml , "text/html"); 
  const len = xmlDoc.getElementsByTagName('description').length;
  let tag;
  for(let i=0; i<len; i++) {
    tag =  xmlDoc.getElementsByTagName('description')[i];
    if(tag.textContent === description) return tag.parentElement.attributes.timestamp.textContent;
  }
}

var xmlData = 
`<?xml version="1.0" encoding="UTF-8"?>
<log>
  <event timestamp="1614285589">
    <description>Intrusion detected</description>
  </event>
  <event timestamp="1614286432">
    <description>Intrusion ended</description>
  </event>
</log>`;
debugger;
var timestamps = getTimestampsByDescription(xmlData, "Intrusion ended");
console.log(timestamps == undefined ? timestamps : timestamps.join());