import { VVScreenOrientation } from 'vv-screenorientation';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    VVScreenOrientation.echo({ value: inputValue })
}
