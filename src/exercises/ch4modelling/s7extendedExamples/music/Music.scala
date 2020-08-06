sealed trait Music

sealed trait Melody extends Music
final case class MelodyCell(head: MusicAction, tail: Melody) extends Melody
final case object MelodyEnd extends Melody

sealed trait MusicAction extends Music {
  def duration: Duration

  def bar: Int
}

final case class Note(
                       tone: Tone,
                       octave: Octave,
                       duration: Duration,
                       key: Key,
                       bar: Int,
                       accidental: Accidental
                     ) extends MusicAction

final case class Rest(
                       duration: Duration,
                       bar: Int
                     ) extends MusicAction


sealed trait ActionElement

sealed trait Duration extends ActionElement {
  def baseDuration: BaseDuration

  def isDotted: Boolean

  sealed trait BaseDuration {
    def value: Double
  }

  case object Whole extends BaseDuration {
    val value = 1
  }

  case object Half extends BaseDuration {
    val value = 1 / 2
  }

  case object Quarter extends BaseDuration {
    val value = 1 / 4
  }

}

sealed trait NoteElement extends ActionElement

sealed trait Tone extends NoteElement {
  def letter: Char

  def octave4Frequency: Double

  def octave4Wavelength: Double
}

final case class Octave(value: Int) extends NoteElement

final case class Key(value: String) extends NoteElement

sealed trait Accidental extends NoteElement






object C extends Tone {
  val letter = 'C'
  val octave4Frequency = 261.63
  val octave4Wavelength = 131.87
}

object D extends Tone {
  val letter = 'D'
  val octave4Frequency = 293.66
  val octave4Wavelength = 117.48
}

case object Flat extends Accidental

case object Sharp extends Accidental

case object Natural extends Accidental
