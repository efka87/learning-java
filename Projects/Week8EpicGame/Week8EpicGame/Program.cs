using System;

namespace DataFromFile
{
    class Program
    {
        static void Main(string[] args)
        {
            string villainsFilePath = @"/Users/../Projects/villains.txt";

            string weaponsFilePath = @"/Users/../Projects/weapons.txt";

            string[] dataFromVillainsFile = File.ReadAllLines(villainsFilePath);

            //Console.WriteLine("Contents of villains.txt:");
            //foreach (string villainLine in dataFromVillainsFile)
            //{
            //    Console.WriteLine(villainLine);
            //}

            string heroesFilePath = @"/Users/../Projects/heroes.txt";
            string[] heroes = File.ReadAllLines(heroesFilePath);
            string[] villains = File.ReadAllLines(villainsFilePath);
            string[] weapons = File.ReadAllLines(weaponsFilePath);



            //string[] heroes = { "Harry Potter", "Luke Skywalker", "Lara Croft", "Scooby-Doo" };
            //string[] villains = { "Voldemort", "Darth Vader", "Dracula", "Joker", "Sauron" };
            //string[] weapon = { "magic wand", "plastic fork", "banana", "wooden sword", "Lego brick" };

            string hero = GetRandomValueFromArray(heroes);
            string heroWeapon = GetRandomValueFromArray(weapons);
            int heroHP = GetCharacterHP(hero);
            int heroStrikeStrength = heroHP;
            Console.WriteLine($"Today {hero} ({heroHP} HP) with {heroWeapon} saves the day!");


            string villain = GetRandomValueFromArray(villains);
            string villainWeapon = GetRandomValueFromArray(weapons);
            int villainHP = GetCharacterHP(villain);
            int villainStrikeStrength = villainHP;
            Console.WriteLine($"Today {villain} ({villainHP} HP) with {villainWeapon} tries to take over the world");

            while (heroHP > 0 && villainHP > 0)
            {
                heroHP = heroHP - Hit(villain, villainStrikeStrength);
                villainHP = villainHP - Hit(hero, heroStrikeStrength);
            }

            Console.WriteLine($"Hero {hero} HP: {heroHP}");
            Console.WriteLine($"Villain {villain} HP: {villainHP}");


            if (heroHP > 0)
            {
                Console.WriteLine($"{hero} saves the day!");
            }
            else if (villainHP > 0)
            {
                Console.WriteLine($"Dark side wins!");
            }
            else
            {
                Console.WriteLine("Draw!");
            }

            static string GetRandomValueFromArray(string[] someArray)
            {
                Random rnd = new Random();
                int randomIndex = rnd.Next(0, someArray.Length);
                string randomStringFromArray = someArray[randomIndex];
                return randomStringFromArray;
            }

            static int GetCharacterHP(string characterName)
            {
                if (characterName.Length < 10)
                {
                    return 10;
                }
                else
                {
                    return characterName.Length;
                }

            }
            static int Hit(string characterName, int characterHP)
            {
                Random rnd = new Random();
                int strike = rnd.Next(0, characterHP);

                if (strike == 0)
                {
                    Console.WriteLine($"{characterName} missed the target!");
                }
                else if (strike == characterHP - 1)
                {
                    Console.WriteLine($"{characterName} made a critical hit!");
                }
                else
                {
                    Console.WriteLine($"{characterName} hit for {strike} damage!");
                }

                return strike;
            }

        }
    }
}
