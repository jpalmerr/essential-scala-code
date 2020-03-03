package part2

// ----------------------------------------------

/*
scala3 is bringing out Enum syntax :)
 */

// Write a definition for Color here!

case class Color(red: Double, green: Double, blue: Double)

// Write definitions for Shape, Circle, and Rect here!

/*
Sealed -- not only are circle and rectangles shapes, they are the only shapes
 */

// structural recursion
object Canvas {
  def draw(shape: Shape): Unit = {
    shape match {
      case Circle(radius, color) => ???
      case Rect(width, height, color) => ???
    }
  }
}

sealed trait Shape {
  def perimeter: Double
  def area: Double
  def color: Color
}

case class Circle(radius: Double, color: Color) extends Shape {
  override def perimeter: Double = 2 * math.Pi * radius
  override def area: Double = math.Pi * (radius * radius)
}
case class Rect(width: Double, height: Double, color: Color) extends Shape {
  override def perimeter: Double = 2 * (width + height)
  override def area: Double = width * height
}

// ----------------------------------------------

object Exercise9ColorAndShape {
  def main(args: Array[String]): Unit = {
    println("color")
     println(Color(1, 1, 0))
     println(Color(1, 0, 1))

    println("circle")
     val circle = Circle(30, Color(1, 1, 0))
     println(circle)
     println(circle.area)
     println(circle.perimeter)
     println(circle.color)

    println("rect")
     val rect = Rect(50, 30, Color(1, 0, 1))
     println(rect)
     println(rect.area)
     println(rect.perimeter)
  }
}
