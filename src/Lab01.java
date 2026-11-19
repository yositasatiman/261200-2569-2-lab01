import java.util.Scanner;

/**
 * 261200 Object-Oriented Programming - Lab 01
 *
 * โจทย์:
 *   อ่านจำนวนเต็มไม่ติดลบ n ก่อน แล้วอ่านจำนวนเต็มอีก n ตัว (บรรทัดละตัว)
 *   จากนั้นพิมพ์ตัวเลขทั้ง n ตัวเรียงจากน้อยไปมาก (ascending) บรรทัดละตัว
 *
 * เงื่อนไข:
 *   - ต้องมี method อื่นนอกจาก main อย่างน้อย 1 ตัว
 *   - ห้ามใช้ Arrays.sort() หรือ Collections.sort()
 *     -> เลยเขียน Insertion Sort เอง
 */
public class Lab01 {

    public static void main(String[] args) {
        // สร้าง Scanner ไว้อ่าน input จากคีย์บอร์ด
        Scanner sc = new Scanner(System.in);

        // อ่านจำนวนข้อมูล n
        int n = sc.nextInt();

        // อ่านตัวเลข n ตัวมาเก็บใน array
        int[] numbers = readNumbers(sc, n);

        // เรียงตัวเลขจากน้อยไปมาก
        insertionSort(numbers);

        // พิมพ์ผลลัพธ์ บรรทัดละตัว
        printNumbers(numbers);

        sc.close();
    }

    /**
     * อ่านตัวเลข n ตัวจาก Scanner แล้วเก็บไว้ใน array
     *
     * @param sc Scanner ที่ใช้อ่าน input
     * @param n  จำนวนตัวเลขที่ต้องอ่าน
     * @return array ที่มีตัวเลขทั้ง n ตัว
     */
    public static int[] readNumbers(Scanner sc, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    /**
     * เรียง array จากน้อยไปมากด้วย Insertion Sort
     *
     * หลักการ: ไล่หยิบตัวเลขทีละตัว (เรียกว่า key)
     * แล้วเลื่อนตัวที่มากกว่า key ไปทางขวา จนเจอที่ว่างที่เหมาะสม
     * แล้วค่อยวาง key ลงไป (เหมือนเรียงไพ่ในมือ)
     *
     * @param arr array ที่ต้องการเรียง (แก้ไขใน array เดิมเลย)
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];   // ตัวที่กำลังจะหาที่วาง
            int j = i - 1;

            // เลื่อนตัวที่มากกว่า key ไปทางขวาทีละช่อง
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // วาง key ลงในตำแหน่งที่ถูกต้อง
            arr[j + 1] = key;
        }
    }

    /**
     * พิมพ์ตัวเลขใน array บรรทัดละตัว
     *
     * @param arr array ที่ต้องการพิมพ์
     */
    public static void printNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
