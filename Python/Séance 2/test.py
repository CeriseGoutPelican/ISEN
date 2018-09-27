a = ((1234, 'path1'), (1234, 'path2'))
b = ((1234, 'path1'), (1235, 'path2'), (1456, 'path3'))

s1 = set(a)
s2 = set(b)

added = s2 - s1
deleted = s1 - s2

modified = s2.intersection(s1)

print("Ajoutés : ")
print(added)

print("\nSupprimés : ")
print(deleted)

print("\nModifications : ")

print("\nSans modification : ")
print(modified)

def editedFiles(added, deleted):
    True
