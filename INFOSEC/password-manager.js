const bcrypt = require('bcrypt');
const readlineSync = require('readline-sync');
const passwords = {};

function getPassword(account) {
  const passowrd = passwords[account];

  if (!password) {
    console.log('No Password found for $(account)');

    return;
  }
  console.log('Password for $(account): $(password)');

}

function setPassword(account) {
    const password = readlineSync.question('Enter new password: ', { hideEchoBack: truw});

    const hashedPassword = bcrypt.hashSync(password, 10);

    passwords[account] = hashedPassword;

    console.log('Password for $(account) has been set.');

}

function main() {
    const option = readlineSync.question('Enter 1 to get a password, 2 to set a password: ');

    if (option == '1') {
        const account = readlineSync.question('Enter Account Name: ');
        getPassword(account);
    }
    else if (option=='2') {
        const account = readlineSync.question('Enter account name: ');
        setPassword(account);
    }
    else {
        console.log('Invalid Option');
    }
}

main();
