buildUrl = (rover, sol) => {
	if (rover === null)
		rover = document.getElementById('currRover').innerText
	rover = rover.toLowerCase().trim()

	if (sol === null)
		sol = document.getElementById('currSol').innerText

	return `?rover=${ rover }&sol=${ sol }`
}

redirect = (url) => {
	window.location = url
}

selectRover = rover => {
	const url = buildUrl(rover, null)

	redirect(url)
}

selectSol = (event) => {
	event.preventDefault()

	const sol = document.getElementById('inputSol').value,
		  url = buildUrl(null, sol)

	redirect(url)
}

toggleAudio = () => {
    console.log('toggleAudio')
    document.getElementById("mute").classList.toggle("d-none")
    document.getElementById("unmute").classList.toggle("d-none")
    document.getElementById("audio").muted = !document.getElementById("audio").muted
    document.getElementById("audio").play()
}