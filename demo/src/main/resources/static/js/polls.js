document.querySelector('#addChoice').addEventListener('click', (e) => {
	const choices = document.querySelector('#choices');
	const newChoice = choices.lastElementChild.cloneNode(true);
	newChoice.querySelectorAll('input').forEach(d => {
		d.name = d.name.replace(/\[(\d+)\]/, (match, p1) => `[${parseInt(p1) + 1}]`);
	});
	newChoice.querySelector('input').value = '';
	choices.appendChild(newChoice);
});