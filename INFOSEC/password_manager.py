import bcrypt
from getpass import getpass

passwords = {}

def get_password(account):
    password = passwords.get(account)
    if password:
        print(f"Password for {account}: {password.decode('utf-8')}")
    else:
        print(f"No password found for {account}")

def set_password(account):
    password = getpass(f"Enter new password for {account}: ").encode('utf-8')
    hashed_password = bcrypt.hashpw(password, bcrypt.gensalt())
    passwords[account] = hashed_password
    print(f"Password for {account} has been set.")

def main():

    option = input("Enter 1 to get a password, 2 to set a password: ")

    if option == '1':
        account = input("Enter account name: ")
        get_password(account)

    elif option == '2':
        account = input("Enter account name: ")
        set_password(account)

    else:
        print("Invalid Option")

if __name__ == "__main__":

    main()
