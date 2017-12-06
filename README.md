# Mooresville Mobile Dev Meetup # 3
## Topic: Encoding and Decoding Data

### We continue working with the [TheMovieDB service](https://www.themoviedb.org/documentation/api) to show improved methods of parsing data into usable objects in our app.

#### iOS Notes
As of Swift 4, JSON encoding and decoding became a lot easier. Using model objects that adhere to the Codable protocol gets you a large way toward quick and easy decoding. Edge cases and custom unboxing/boxing can be handled on a case by case basis, but the majority of instances of turning data into usable model objects is abstracted away from you.

##### References:
- [Apple Documentation]
- [Encoding and Decoding Custom Types]
- [Ultimate Guide to Parsing JSON with Swift 4]
    - This guide is excellent, and covers the majority of edge cases

[Apple Documentation]: https://developer.apple.com/documentation/swift/codable
[Encoding and Decoding Custom Types]: https://developer.apple.com/documentation/foundation/archives_and_serialization/encoding_and_decoding_custom_types
[Ultimate Guide to Parsing JSON with Swift 4]: https://benscheirman.com/2017/06/swift-json/
