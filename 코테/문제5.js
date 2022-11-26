function solution(paths) {

    var answer ='';
    var check = ['.','..','...'];

    paths.forEach(path => {
        if(path.indexOf('/') === 0) answer += path;        
        else answer += '/' + path;     

       if(path.includes('...')) {
            const sp = answer.split('/');
            const spIdx = sp.indexOf('...');
            answer = [...sp.slice(0, spIdx-3), ...sp.slice(spIdx+1)].join('/');
        } else if(path.includes('..')) {        
            const sp = answer.split('/');
            const spIdx = sp.indexOf('..');
            answer = [...sp.slice(0, spIdx-1), ...sp.slice(spIdx+1)].join('/');
            
        } else  if(path.includes('.')) {
            answer = answer.replace('./','');
        } 
    });
    
    return answer;
}
solution(["/foo", "bar", "baz/asdf", "q", ".."])