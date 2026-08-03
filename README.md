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

![]()

Add New Book Screen

![]()

Book Details & Status Update

![]()

Delete Confirmation Dialog

![]()
