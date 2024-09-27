const express = require("express");
const { exec } = require("child_process");
const ejs = require("ejs");
const path = require("path");
const { error } = require("console");
const { report } = require("process");
const app = express();


const { clearScreenDown } = require("readline");
const static_path = path.join(__dirname, "../public");
const template_path = path.join(__dirname, "../templates/views");


app.use(express.json());

app.use(express.urlencoded({ extended: false }));
app.use(express.static(static_path));
app.set("view engine", 'ejs');
app.set("views", template_path);




app.get('/', (req, res) => {

    res.render("home")

})

app.get('/scanner', (req, res) => {
    res.render("scanner");
});
app.get('/scanreport', (req, res) => {
    res.render("report");
});


app.post('/scan', (req, res) => {
    const { stype } = req.body;
    //console.log(stype);
    const { target } = req.body;
    const mport = req.body;

    //console.log(target);
    exec(`nmap ${stype} ${mport} ${target}`, (error, stdout, stderr) => {
        if (error) {
            console.error(`Error: ${error.message}`);
            res.status(404).render("404");
            return;
        }
        //console.log(stdout);
        const report = stdout;
        const jsonOutput = {
            message: report 
        };
        res.send(jsonOutput)
        

    })
})





app.listen(3000, () => {
    console.log(`server running at http://localhost:3000/`);
})