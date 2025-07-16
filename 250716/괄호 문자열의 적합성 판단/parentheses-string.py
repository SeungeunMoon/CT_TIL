class Stack:
    def __init__(self):
        self.items = []
    
    def push(self, value):
        self.items.append(value)
    
    def pop(self):
        try:
            return self.items.pop()
        except IndexError:
            return False
    
    def top(self):
        try:
            return self.items.pop()
        except IndexError:
            return False
    
    def isExist(self):
        return len(self.items)
    
    def __len__(self):
        return len(self.items)


def check(inputValue):
    outvalue = []
    s = Stack()

    for p in inputValue:
        try:
            if p =="(":
                s.push(p)
            else:
                s.pop()
        except:
            return "No"
    
    if s.isExist():
        return "No"
    else:
        return "Yes"



inputValue = input()
ans = check(inputValue)
print(ans)