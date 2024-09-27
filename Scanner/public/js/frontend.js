const scanform = document.getElementById('scanform');



scanform.addEventListener('submit', (e) => {
    e.preventDefault()
    const option = document.getElementById('myselect');
    const opval = option.value;
    // option.value = ''

    const myport = document.getElementById('myport');
    const port = myport.value;
    // myport.value = ''

    const mytarget = document.getElementById('mytarget');
    const target = mytarget.value;



    if (target === "") {
        window.alert("enter target !!!");
    } else {
        if (opval !== '-p' && port !== '') {
            window.alert("select option -p for entering port number")
            myport.value = ''
            mytarget.value = ''

        } else {
            const obj = new Object();
            obj.opval = opval;
            obj.port = port;
            obj.target = target;

            startscan(obj);
        }
    }
});

const container = document.getElementById('container');
const orignalContent = container.innerHTML
const gobackbtn = document.createElement('button');
gobackbtn.id = 'goback';
gobackbtn.textContent = "Go back";

async function startscan(obj) {
    try {
        const response = await fetch('http://localhost:3000/scan', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(obj)
        })
            .then(response => response.json())
            .then(data => {
                

                container.innerHTML = ''

                const report = document.createElement('div');
                report.id = 'reportid'


                const h1 = document.createElement('h1');
                h1.id = 'header';
                h1.innerText = "The scan report :-";

                const pre = document.createElement('pre');
                pre.id = 'rep';
                

                const d = document.createTextNode(data.message);
                pre.appendChild(d);
                const hd = document.createElement('h3');
                hd.appendChild(pre)

                report.appendChild(h1);
                report.appendChild(hd);
                report.appendChild(gobackbtn);
                container.appendChild(report)



            })

    } catch (error) {
        console.log(error);

    }
}

gobackbtn.addEventListener('click', function () {
    container.innerHTML = orignalContent
})
