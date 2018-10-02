a = (('path1', 1234), ('path2', 1234))
b = (('path1', 1234), ('path2', 12345), ('path3', 401394))

print("Liste avant : ")
print(a)

print("Liste après : ")
print(b)

s1 = set(a)
s2 = set(b)

added = s2 - s1
deleted = s1 - s2

unedited = s2.intersection(s1)

def editedFiles(added, deleted):
    # 1. Récupération des index de suppression
    deletedPaths = []
    for e in deleted:
        deletedPaths.append(e[0])

    # 2. Comparaison des éléments
    edited = []
    for e in added:
        if e[0] in deletedPaths:
            edited.append(e)

    return edited

print("\nAjoutés : ")
print(added)

print("\nSupprimés : ")
print(deleted)

print("\nModifications : ")
print(editedFiles(added, deleted))

print("\nSans modification : ")
print(unedited)

