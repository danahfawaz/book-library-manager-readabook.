readabook - Android Studio Project
==================================

Topic: Book Library Manager, implemented as "readabook" (personal reading tracker).
Package: com.readabook.app  |  Language: Java  |  Database: SQLite  |  Min SDK 21 / Target SDK 34.

HOW TO OPEN
-----------
1. Android Studio -> File > Open -> select the project folder.
2. Let Gradle sync finish (needs internet on first sync).
3. Press Run to build and launch on an emulator or device.

STRUCTURE
---------
app/src/main/java/com/readabook/app/
    BookEntry.java          - data model (title, author, category, status, rating)
    ReadaBookDB.java        - SQLite (Insert / Update / Delete / Search / Select All)
    LibraryActivity.java    - My Shelf: Toolbar + RecyclerView + search + Add
    ShelfAdapter.java       - RecyclerView adapter (CardView rows, status chip + stars)
    NewBookActivity.java    - Add a book (status dropdown + rating)
    BookInfoActivity.java   - View details, update status/rating, delete
    RemoveDialog.java       - DialogFragment (remove confirmation)
app/src/main/res/layout/    - the 4 screen layouts
app/src/main/res/values/    - strings, colors (teal/amber), theme

FEATURES: Add book, Search, Update status & rating, Remove (confirm), Display shelf, View details.
COMPONENTS: RecyclerView, CardView, DialogFragment.

## Screenshots

Home Screen

![](Screenshots/01-%20Home%20Screen%20-%20Saved%20Books.jpeg)

Add New Book Screen

![](Screenshots/02-%20Add%20New%20Book%20Screen.jpeg)

Book Details & Status Update

![](Screenshots/03-%20Status%20and%20Rating%20Update%20Screen.jpeg)

Delete Confirmation Dialog

![](Screenshots/04-%20Remove%20Book%20Confirmation%20Dialog.jpeg)

